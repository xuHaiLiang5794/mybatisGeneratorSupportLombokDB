package com.xuhailiang5794.business.mapper;

import com.xuhailiang5794.business.entity.NationalTree;
import com.xuhailiang5794.business.entity.NationalTreeKey;

public interface NationalTreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(NationalTreeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    int insert(NationalTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    int insertSelective(NationalTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    NationalTree selectByPrimaryKey(NationalTreeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(NationalTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_national_tree
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(NationalTree record);
}