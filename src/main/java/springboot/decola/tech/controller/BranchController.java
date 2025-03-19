package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.service.BranchService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

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

        Branch branch = branchService.deleteBranch(id);

        if (branch == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(branch);
    }

}
