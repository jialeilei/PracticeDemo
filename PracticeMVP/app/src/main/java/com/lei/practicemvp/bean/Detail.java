package com.lei.practicemvp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by CCC on 2016/8/18.
 */
@Table(name = "detail")
public class Detail {
    @Column(name = "id",isId = true,autoGen = true)
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "age")
    public int age;

    public Detail(){}

    public Detail(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
@Column(name = "id",isId = true,autoGen = true)
public Long id;//	主键	自增
@Column(name = "name")
public String name;//名称
@Column(name = "picture")
public String picture;//照片	压缩
@Column(name = "selected_icon")
public String selectedIcon;
@Column(name = "unselected_icon")
public String unselectedIcon;
@Column(name = "is_selected")
public Integer isSelected;// 	integer 	场景是否被选中 	0：NO,1:YES
    public Room() {
    }*/
