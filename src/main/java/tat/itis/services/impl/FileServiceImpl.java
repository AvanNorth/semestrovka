package tat.itis.services.impl;

import tat.itis.dao.FilesRepository;
import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;
import tat.itis.exceptions.NotFoundException;
import tat.itis.model.FileInfo;
import tat.itis.services.FileService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

public class FileServiceImpl implements FileService {

    private final String path;
    private final FilesRepository filesRepository;
    private final UsersRepository usersRepository;
    private final LabsRepository labsRepository;

    public FileServiceImpl(String path, FilesRepository filesRepository, LabsRepository labsRepository, UsersRepository usersRepository) {
        this.path = path;
        this.filesRepository = filesRepository;
        this.usersRepository = usersRepository;
        this.labsRepository = labsRepository;
    }

    @Override
    public FileInfo saveFileToStorage(UserDto user, InputStream inputStream, String originalFileName, String contentType, Long size) {
        FileInfo fileInfo = new FileInfo(
                null,
                originalFileName,
                UUID.randomUUID().toString(),
                size,
                contentType
        );
        try {
            Files.copy(inputStream, Paths.get(path + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            fileInfo = filesRepository.save(fileInfo);
            usersRepository.updateAvatarForUser(user.getId(), fileInfo.getId());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return fileInfo;
    }

    @Override
    public FileInfo saveFileToStorage(LabDto lab, InputStream file, String originalFileName, String contentType, Long size) {
        FileInfo fileInfo = new FileInfo(
                null,
                originalFileName,
                UUID.randomUUID().toString(),
                size,
                contentType
        );
        try {
            Files.copy(file, Paths.get(path + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            fileInfo = filesRepository.save(fileInfo);
            labsRepository.updateAvatarForLab(lab.getId(), fileInfo.getId());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return fileInfo;
    }

    @Override
    public void readFileFromStorage(Long fileId, OutputStream outputStream) {
        Optional<FileInfo> optionalFileInfo = filesRepository.findById(fileId);
        FileInfo fileInfo = optionalFileInfo.orElseThrow(() -> new NotFoundException("File not found"));

        File file = new File(path + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]);
        try {
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public FileInfo getFileInfo(Long fileId) {
        return filesRepository.findById(fileId).orElseThrow(() -> new NotFoundException("File not found"));
    }
}
