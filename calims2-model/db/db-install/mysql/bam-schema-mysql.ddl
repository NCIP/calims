
    create table bam_NodeInstanceLog (
        id bigint not null auto_increment,
        type integer,
        nodeInstanceId varchar(255),
        nodeId varchar(255),
        processInstanceId bigint,
        processId varchar(255),
        DATE datetime,
        primary key (id)
    );

    create table bam_ProcessInstanceLog (
        id bigint not null auto_increment,
        processInstanceId bigint,
        processId varchar(255),
        START_DATE datetime,
        END_DATE datetime,
        primary key (id)
    );
