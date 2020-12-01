package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.DynamicMapper;
import com.example.test.bean.Dynamic;
import com.example.test.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl implements DynamicService{
    @Autowired
    private DynamicMapper dynamicMapper;
    @Override
    public long getDynamicRowCount(){
        return dynamicMapper.getDynamicRowCount();
    }
    @Override
    public List<Dynamic> selectDynamic(){
        return dynamicMapper.selectDynamic();
    }
    @Override
    public Dynamic selectDynamicById(Integer id){
        return dynamicMapper.selectDynamicById(id);
    }
    @Override
    public int insertDynamic(Dynamic value){
        return dynamicMapper.insertDynamic(value);
    }
    @Override
    public int insertNonEmptyDynamic(Dynamic value){
        return dynamicMapper.insertNonEmptyDynamic(value);
    }
    @Override
    public int deleteDynamicById(Integer id){
        return dynamicMapper.deleteDynamicById(id);
    }
    @Override
    public int updateDynamicById(Dynamic enti){
        return dynamicMapper.updateDynamicById(enti);
    }
    @Override
    public int updateNonEmptyDynamicById(Dynamic enti){
        return dynamicMapper.updateNonEmptyDynamicById(enti);
    }

    @Override
    public List<Dynamic> getDynamicByPage(int page, int pagesize) {
        return dynamicMapper.getDynamicByPage(page,pagesize);
    }

    @Override
    public int updateLikeNum(Integer id) {
        return dynamicMapper.updateLikeNum(id);
    }

    public DynamicMapper getDynamicMapper() {
        return this.dynamicMapper;
    }

    public void setDynamicMapper(DynamicMapper dynamicMapper) {
        this.dynamicMapper = dynamicMapper;
    }

}