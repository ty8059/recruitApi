package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.dao.TblPositionMapper;
import com.admn.console.model.TblPosition;
import com.admn.console.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private TblPositionMapper positionMapper;

    @Override
    public TblPosition getByPositionId(Integer positionId) {
        return positionMapper.getByPositionId(positionId);
    }

    @Override
    public Layui getByPositionName(String positionName, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblPosition> list = positionMapper.findByPositionName(positionName);
        PageInfo<TblPosition> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "positionList");
    }

    @Override
    public ResultEntity addPosition(TblPosition position) {
        int result = positionMapper.insertSelective(position);
        if (result > 0) {
            return new ResultEntity(true, "添加职位成功");
        } else {
            return new ResultEntity(false, "添加职位失败");
        }
    }

    @Override
    public ResultEntity editPosition(TblPosition position) {
        if (positionMapper.getByPositionId(position.getPositionId()) == null) {
            return new ResultEntity(false, "该职位不存在");
        }
        Example example = new Example(TblPosition.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("positionId", position.getPositionId());
        int result = positionMapper.updateByExampleSelective(position, example);
        if (result > 0) {
            return new ResultEntity(true, "修改职位成功");
        } else {
            return new ResultEntity(false, "修改职位失败");
        }
    }
}
