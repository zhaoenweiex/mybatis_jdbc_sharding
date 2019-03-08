package self.ctrl;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import self.model.ResultData;
import self.model.User;
import self.service.ResultDataService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaoenwei
 * @date 2017/7/26
 */
@Slf4j
@RestController
@RequestMapping("/result_data")
public class ResultDataCtrl {
    private final ResultDataService resultDataService;

    @Autowired
    public ResultDataCtrl(ResultDataService resultDataService) {
        this.resultDataService = resultDataService;
    }
    @GetMapping("/count")
    public Long getCount(){
        return resultDataService.count();
    }
    @DeleteMapping("/all")
    public Boolean deleteAll(){
        return resultDataService.deleteAll();
    }
    @GetMapping("/datas")
    public List<ResultData> findAll(){
        return resultDataService.findAll();
    }
    @GetMapping("/list/{limit}")
    public List<ResultData> findAll(@PathVariable int limit){
        return resultDataService.findAllByLimit(limit);
    }
    @GetMapping("/data")
    public List<ResultData> findAll(ResultData data){
        return resultDataService.findAllByExample(data);
    }
    @PostMapping("/datas/{total}")
    public boolean iniDbWith2000W(@PathVariable Long total){
        int batchSize = 2000;
        long offSet = 0;
        long start=System.currentTimeMillis();
        try{
            for (Long i = offSet; i < total/ batchSize; i++) {
                List<ResultData> list=new ArrayList<>();

                for (int j = 0; j < batchSize; j++) {
                    ResultData data=new ResultData();
                    data.setResultDataId(i* batchSize +j);
                    data.setRemark("我是第"+i* batchSize +j+"产生");

                    User user=new User();
                    user.setUserId(i%2);
                    data.setUploadUser(user);
                    list.add(data);
                }

                resultDataService.addAll(list);
                long now=System.currentTimeMillis();
                log.info("完成{}批量插入，进度{}%",i,i*batchSize*100/total);
                if(i>0){
                    Double totalTime= (now - start) / 1000.0 / (((double)(i * batchSize)) / total);
                    log.info("已用{}秒，预计还需{}秒",(now-start)/1000,totalTime-(now-start)/1000.0);
                }

            }
        }catch (Exception e){
            log.error("错误",e);
            return false;
        }

        return true;
    }
}

