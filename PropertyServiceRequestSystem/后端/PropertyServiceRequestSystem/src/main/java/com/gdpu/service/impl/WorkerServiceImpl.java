package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.pojo.Worker;
import com.gdpu.service.WorkerService;
import com.gdpu.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ASUS
* @description 针对表【worker】的数据库操作Service实现
* @createDate 2024-08-21 17:22:25
*/
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker>
    implements WorkerService{

    @Autowired
    private WorkerMapper workerMapper;

    public List<Worker> getAllWorkers() {
        return workerMapper.getAllWorkers();
    }

    public Worker getWorkerById(Long id) {
        return workerMapper.getWorkerById(id);
    }

    public void saveWorker(Worker worker) {
        if (worker.getWorkerId() == null) {
            workerMapper.insertWorker(worker);
        } else {
            workerMapper.updateWorker(worker);
        }
    }

    public void deleteWorker(Long id) {
        workerMapper.deleteWorker(id);
    }
}




