package tat.itis.services;

import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;
import tat.itis.model.FileInfo;

import java.io.InputStream;
import java.io.OutputStream;

public interface FileService {
    FileInfo saveFileToStorage(UserDto user, InputStream file, String originalFileName, String contentType, Long size);
    FileInfo saveFileToStorage(LabDto labDto, InputStream file, String originalFileName, String contentType, Long size);
    void readFileFromStorage(Long fileId, OutputStream outputStream);
    FileInfo getFileInfo(Long fileId);
}