package com.example.demo.service;

import com.example.demo.dto.RepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RepositoryService {
    public RepositoryDTO insertRepository(RepositoryDTO repositoryDTO);
    public List<RepositoryDTO> getAllRepositoriesByName(int pageNumber,String name);
    public RepositoryDTO getRepositoryByID(int id);
    public RepositoryDTO updateRepository(RepositoryDTO repositoryDTO);
    public boolean deleteRepository(int id);
    public boolean deleteSqlRepository(int id);
}
