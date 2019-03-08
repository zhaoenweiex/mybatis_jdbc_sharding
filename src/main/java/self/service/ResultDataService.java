package self.service;

import self.model.ResultData;

import java.util.List;

/**
 *
 * @author zhaoenwei
 * @date 2017/7/27
 */
public interface ResultDataService {
    void create(ResultData resultData);

    List<ResultData> findAll();

    List<ResultData> findAllByExample(ResultData data);

    void addAll(List<ResultData> list);

    Long count();

    List<ResultData> findAllByLimit(int limit);

    Boolean deleteAll();
}
