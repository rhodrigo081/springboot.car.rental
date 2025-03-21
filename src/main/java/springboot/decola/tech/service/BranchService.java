package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.repository.BranchRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch saveBranch(Branch branch) {

        if (branch.getCnpj() == null || branch.getCnpj().isEmpty() ||
                branch.getName() == null || branch.getName().isEmpty() ||
                branch.getPhone() == null || branch.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Fill in all fields");
        }

        return branchRepository.save(branch);
    }

    public List<Branch> findByNameBranch(String name) {

        List<Branch> searchedBranch = branchRepository.findByName(name);

        if (searchedBranch.isEmpty() || searchedBranch == null) {
            throw new NoSuchElementException("Branch does not exist");
        }

        return searchedBranch;

    }

    public List<Branch> findAllBranches() {

        List<Branch> branches = branchRepository.findAll();

        if (branches.isEmpty() || branches == null) {
            throw new NoSuchElementException("No branches created");
        }

        return branches;
    }

    public Branch deleteBranch(Long id) {

        Branch deletedBranch = branchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Branch does not exist"));

        return deletedBranch;

    }
}
