package com.gdpu.controller;

import com.gdpu.pojo.Worker;
import com.gdpu.service.WorkerService;
import com.gdpu.service.impl.WorkerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private WorkerServiceImpl workerService;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable Long id) {
        return workerService.getWorkerById(id);
    }

    @PostMapping
    public void createWorker(@RequestBody Worker worker) {
        workerService.saveWorker(worker);
    }

    @PutMapping("/{id}")
    public void updateWorker(@PathVariable Integer id, @RequestBody Worker worker) {
        worker.setWorkerId(id);
        workerService.saveWorker(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
    }
}
