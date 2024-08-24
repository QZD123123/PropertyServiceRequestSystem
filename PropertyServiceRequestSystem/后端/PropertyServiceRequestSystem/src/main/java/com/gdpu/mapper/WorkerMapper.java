package com.gdpu.mapper;

import com.gdpu.pojo.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
* @author ASUS
* @description 针对表【worker】的数据库操作Mapper
* @createDate 2024-08-21 17:22:25
* @Entity com.gdpu.pojo.Worker
*/
public interface WorkerMapper extends BaseMapper<Worker> {

    @Select("SELECT * FROM worker")
    List<Worker> getAllWorkers();

    @Select("SELECT * FROM worker WHERE worker_id = #{id}")
    Worker getWorkerById(Long id);

    @Insert("INSERT INTO worker (worker_phone, worker_name) VALUES (#{workerPhone}, #{workerName})")
    @Options(useGeneratedKeys = true, keyProperty = "workerId")
    void insertWorker(Worker worker);

    @Update("UPDATE worker SET worker_phone = #{workerPhone}, worker_name = #{workerName} WHERE worker_id = #{workerId}")
    void updateWorker(Worker worker);

    @Delete("DELETE FROM worker WHERE worker_id = #{id}")
    void deleteWorker(Long id);
}





