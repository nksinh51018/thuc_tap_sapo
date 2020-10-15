package com.example.demo.service.impl;

import com.example.demo.dao.RepositoryDAO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.RepositoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Repository;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.RepositoryMapper;
import com.example.demo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Value("${myApplication.recordNum}")
    private int recordNum;

    @Autowired
    private RepositoryDAO repositoryDAO;

    @Override
    public RepositoryDTO insertRepository(RepositoryDTO repositoryDTO) {
        if(repositoryDTO.getLocation() == null || repositoryDTO.getRepositoryName() == null){
            return null;
        }
        Repository repository = RepositoryMapper.mapRepositoryDTOToRepository(repositoryDTO);
        repository.setId(0);
        Date now = new Date();
        repository.setCreatedAt(now);
        repository.setUpdatedAt(now);
        try {
            repositoryDAO.save(repository);
            return repositoryDTO;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RepositoryDTO> getAllRepositoriesByName(int pageNumber,String name) {
        List<Repository> repositories = new ArrayList<>();
//        Page<Repository> repositoryPage = repositoryDAO.findAll(PageRequest.of(pageNumber-1,recordNum));
//
//        repositoryPage.forEach(repository -> {
//            repositories.add(repository);
//        });

        List<RepositoryDTO> repositoryDTOs = new ArrayList<>();
        repositories.forEach(repository -> repositoryDTOs.add(RepositoryMapper.mapRepositoryToRepositoryDTO(repository)));
        return repositoryDTOs;
    }

    @Override
    public RepositoryDTO getRepositoryByID(int id) {
        Repository repository =  repositoryDAO.findById(id).orElse(null);
        if(repository == null){
            return null;
        }
        return RepositoryMapper.mapRepositoryToRepositoryDTO(repository);
    }

    @Override
    public RepositoryDTO updateRepository(RepositoryDTO repositoryDTO) {
        Repository repository = repositoryDAO.findById(repositoryDTO.getId()).orElse(null);
        if(repository == null){
            return null;
        }
        repository = updateRepository(repository,repositoryDTO);
        try {
            repositoryDAO.save(repository);
            return repositoryDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteRepository(int id) {
        try {
            repositoryDAO.deleteById(id);
            return  true;
        }
        catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean deleteSqlRepository(int id) {

        try {
            repositoryDAO.deleteSqlRepository(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private Repository updateRepository(Repository repository,RepositoryDTO repositoryDTO){
        Date now = new Date();
        repository.setUpdatedAt(now);
        String repositoryName = repositoryDTO.getRepositoryName();
        String location = repositoryDTO.getLocation();
        if(repositoryName != null){
            repository.setRepositoryName(repositoryName);
        }
        if(location != null){
            repository.setLocation(location);
        }
        return repository;
    }
}
