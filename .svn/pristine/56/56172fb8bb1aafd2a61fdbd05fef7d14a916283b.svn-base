package com.huidong.qzh.portal.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ap_album")
public class ApAlbum {
    /**
     * 主键,自增1
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 创建者的公司ID
     */
    @Column(name = "memberId")
    private Integer memberid;

    /**
     * 创建者的账户ID
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 相册名称
     */
    @Column(name = "albumName")
    private String albumname;

    /**
     * 创建日期
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 相册描述
     */
    @Column(name = "albumDesc")
    private String albumdesc;

    /**
     * 最后一次上传的图片的路径（默认图片）
     */
    @Column(name = "lastPictureUrl")
    private String lastpictureurl;

    /**
     * 是否对外开放（是否展示）0代表不展示,1代表展示
     */
    @Column(name = "isShow")
    private Integer isshow;

    /**
     * 获取主键,自增1
     *
     * @return id - 主键,自增1
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键,自增1
     *
     * @param id 主键,自增1
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建者的公司ID
     *
     * @return memberId - 创建者的公司ID
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * 设置创建者的公司ID
     *
     * @param memberid 创建者的公司ID
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * 获取创建者的账户ID
     *
     * @return accountId - 创建者的账户ID
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置创建者的账户ID
     *
     * @param accountid 创建者的账户ID
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取相册名称
     *
     * @return albumName - 相册名称
     */
    public String getAlbumname() {
        return albumname;
    }

    /**
     * 设置相册名称
     *
     * @param albumname 相册名称
     */
    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    /**
     * 获取创建日期
     *
     * @return createDate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取相册描述
     *
     * @return albumDesc - 相册描述
     */
    public String getAlbumdesc() {
        return albumdesc;
    }

    /**
     * 设置相册描述
     *
     * @param albumdesc 相册描述
     */
    public void setAlbumdesc(String albumdesc) {
        this.albumdesc = albumdesc;
    }

    /**
     * 获取最后一次上传的图片的路径（默认图片）
     *
     * @return lastPictureUrl - 最后一次上传的图片的路径（默认图片）
     */
    public String getLastpictureurl() {
        return lastpictureurl;
    }

    /**
     * 设置最后一次上传的图片的路径（默认图片）
     *
     * @param lastpictureurl 最后一次上传的图片的路径（默认图片）
     */
    public void setLastpictureurl(String lastpictureurl) {
        this.lastpictureurl = lastpictureurl;
    }

    /**
     * 获取是否对外开放（是否展示）0代表不展示,1代表展示
     *
     * @return isShow - 是否对外开放（是否展示）0代表不展示,1代表展示
     */
    public Integer getIsshow() {
        return isshow;
    }

    /**
     * 设置是否对外开放（是否展示）0代表不展示,1代表展示
     *
     * @param isshow 是否对外开放（是否展示）0代表不展示,1代表展示
     */
    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }
}