package self.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import self.model.ResultData;
import self.utils.MyMapper;

import java.util.List;

/**
 * Created by zhaoenwei on 2017/7/27.
 */
public interface ResultDataMapper extends MyMapper<ResultData> {
    @Insert("insert into result_data(result_data_id,remark,upload_user_id) values(#{resultDataId},#{remark},#{uploadUser.userId})")
    Boolean create(ResultData resultData);
    @Select("select * from result_data limit #{limit}")
    List<ResultData> findAllByLimit(int limit);
}
