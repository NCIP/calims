
    create table bam_NodeInstanceLog (
        id int8 not null,
        type int4,
        nodeInstanceId varchar(255),
        nodeId varchar(255),
        processInstanceId int8,
        processId varchar(255),
        DATE timestamp,
        primary key (id)
    );

    create table bam_ProcessInstanceLog (
        id int8 not null,
        processInstanceId int8,
        processId varchar(255),
        START_DATE timestamp,
        END_DATE timestamp,
        primary key (id)
    );

