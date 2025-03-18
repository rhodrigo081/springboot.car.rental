package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.repository.BranchRepository;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public List<Branch> findByNameBranch(String nameBranch) {
        return branchRepository.findByNameBranch(nameBranch);
    }

    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }

    public Branch deleteBranch(Long id) {
        Branch branch = branchRepository.findById(id).orElse(null);
        if (branch != null) {
            branchRepository.delete(branch);
        }
        return branch;
    }
}
