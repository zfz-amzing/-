package com.zfz.xiaomi.entry;

public class GoodsImages {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_images.id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_images.path
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_images.title
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_images.alt
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    private String alt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_images.goods_id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    private Integer goodsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_images.id
     *
     * @return the value of goods_images.id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_images.id
     *
     * @param id the value for goods_images.id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_images.path
     *
     * @return the value of goods_images.path
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_images.path
     *
     * @param path the value for goods_images.path
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_images.title
     *
     * @return the value of goods_images.title
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_images.title
     *
     * @param title the value for goods_images.title
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_images.alt
     *
     * @return the value of goods_images.alt
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public String getAlt() {
        return alt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_images.alt
     *
     * @param alt the value for goods_images.alt
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public void setAlt(String alt) {
        this.alt = alt == null ? null : alt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_images.goods_id
     *
     * @return the value of goods_images.goods_id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_images.goods_id
     *
     * @param goodsId the value for goods_images.goods_id
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}