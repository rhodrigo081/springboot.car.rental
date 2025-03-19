package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.repository.BranchRepository;
import springboot.decola.tech.service.BranchService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;
    @Autowired
    private BranchRepository branchRepository;

    @PostMapping("/save")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {

        Branch savedBranch = branchService.saveBranch(branch);

        return ResponseEntity.ok().body(savedBranch);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Branch>> searchBranch(@PathVariable String name) {
        List<Branch> branches = branchService.findByNameBranch(name);

        if (branches.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(branches);
    }

    @GetMapping("/branches-list")
    public List<Branch> getAllBranches() {
        return branchService.findAllBranches();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Branch> deleteBranch(@PathVariable Long id) {
        Optional<Branch> branchOptional = branchRepository.findById(id);

        if (branchOptional.isPresent()) {
            Branch branch = branchOptional.get();

            branchRepository.delete(branch);

            return ResponseEntity.ok(branch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
