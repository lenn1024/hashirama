package com.example.demo.mapper;

import com.example.demo.entity.PopFreightVender;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PopFreightVenderMapper {
    @Select("SELECT * FROM pop_freight_vender")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "venderId", column = "vender_id")
    })
    List<PopFreightVender> getAll();

}
