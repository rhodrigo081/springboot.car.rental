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

        if (nameBranch == null || nameBranch.isEmpty()) {
            throw new IllegalArgumentException("Branch name is null or empty");
        }

        List<Branch> searchBranch = branchRepository.findByName(nameBranch);

        if(searchBranch.isEmpty()){
            throw new IllegalArgumentException("Branch not found");
        } else {
            return searchBranch;
        }

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
