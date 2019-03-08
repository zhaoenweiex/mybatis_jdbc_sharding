package self.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import self.mapper.ResultDataMapper;
import self.model.ResultData;
import self.service.ResultDataService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhaoenwei
 * @date 2017/7/27
 */
@Service
public class ResultDataServiceImpl implements ResultDataService {
    private final ResultDataMapper resultDataMapper;

    @Override
    public List<ResultData> findAllByExample(ResultData data) {
        Example example=Example.builder(ResultData.class).build();
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(data.getRemark())){
            criteria.andCondition("remark ='"+data.getRemark()+"'");
        }
        return resultDataMapper.selectByExample(example);
    }

    @Override
    public void addAll(List<ResultData> list) {
        resultDataMapper.insertList(list);
    }

    @Override
    public Long count() {
        return (long) resultDataMapper.selectCount(new ResultData());
    }

    @Override
    public Boolean deleteAll() {
        List<ResultData> resultData = resultDataMapper.selectAll();
        try{
            for (ResultData resultDatum : resultData) {
                resultDataMapper.deleteByPrimaryKey(resultDatum.getResultDataId());
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<ResultData> findAllByLimit(int limit) {
        return resultDataMapper.findAllByLimit(limit);
    }

    @Autowired
    public ResultDataServiceImpl(ResultDataMapper resultDataMapper) {
        this.resultDataMapper = resultDataMapper;
    }


    @Override
    public void create(ResultData resultData) {
        resultDataMapper.create(resultData);
    }

    @Override
    public List<ResultData> findAll() {
        return resultDataMapper.selectAll();
    }
}
