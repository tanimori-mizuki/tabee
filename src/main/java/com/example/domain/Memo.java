package com.example.domain;

import java.util.Date;

public class Memo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.content
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.shiori_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Integer shioriId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.is_locked
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Byte isLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.creator_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Integer creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.created_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Date createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.updater_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Integer updaterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.updated_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Date updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memos.version
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.id
     *
     * @return the value of memos.id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.id
     *
     * @param id the value for memos.id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.content
     *
     * @return the value of memos.content
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.content
     *
     * @param content the value for memos.content
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.shiori_id
     *
     * @return the value of memos.shiori_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Integer getShioriId() {
        return shioriId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.shiori_id
     *
     * @param shioriId the value for memos.shiori_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setShioriId(Integer shioriId) {
        this.shioriId = shioriId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.is_locked
     *
     * @return the value of memos.is_locked
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Byte getIsLocked() {
        return isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.is_locked
     *
     * @param isLocked the value for memos.is_locked
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.creator_id
     *
     * @return the value of memos.creator_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.creator_id
     *
     * @param creatorId the value for memos.creator_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.created_at
     *
     * @return the value of memos.created_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.created_at
     *
     * @param createdAt the value for memos.created_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.updater_id
     *
     * @return the value of memos.updater_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Integer getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.updater_id
     *
     * @param updaterId the value for memos.updater_id
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.updated_at
     *
     * @return the value of memos.updated_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.updated_at
     *
     * @param updatedAt the value for memos.updated_at
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memos.version
     *
     * @return the value of memos.version
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memos.version
     *
     * @param version the value for memos.version
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}