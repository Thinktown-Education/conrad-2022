package com.thinktown.conrad2022.dao;

import com.sun.istack.NotNull;
import com.thinktown.conrad2022.constant.MindmapState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "mindmap")
@NoArgsConstructor
public class Mindmap {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @NotNull
    @Column(name = "userid")
    private int userId;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "original_file")
    private String originalFile;

    @Getter
    @Setter
    @Column(name = "converted_file")
    private String convertedFile;

    @Getter
    @Setter
    @Column(name = "created")
    private Date created;

    @Getter
    @Setter
    @Column(name = "updated")
    private Date updated;

    @Getter
    @Setter
    @Column(name = "state")
    private String state;

    public Mindmap(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.state = MindmapState.uploaded;
    }
}
