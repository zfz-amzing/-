package com.zfz.xiaomi.dao;

import com.zfz.xiaomi.entry.GoodsPackage;
import com.zfz.xiaomi.entry.GoodsPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPackageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    long countByExample(GoodsPackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int deleteByExample(GoodsPackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int insert(GoodsPackage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int insertSelective(GoodsPackage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    List<GoodsPackage> selectByExample(GoodsPackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    GoodsPackage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int updateByExampleSelective(@Param("record") GoodsPackage record, @Param("example") GoodsPackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int updateByExample(@Param("record") GoodsPackage record, @Param("example") GoodsPackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int updateByPrimaryKeySelective(GoodsPackage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_package
     *
     * @mbg.generated Sun Feb 23 17:50:09 CST 2020
     */
    int updateByPrimaryKey(GoodsPackage record);
}