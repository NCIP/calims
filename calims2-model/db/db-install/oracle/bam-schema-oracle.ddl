
    create table bam_NodeInstanceLog (
        id number(19,0) not null,
        type number(10,0),
        nodeInstanceId varchar2(255),
        nodeId varchar2(255),
        processInstanceId number(19,0),
        processId varchar2(255),
        DATE date,
        primary key (id)
    );

    create table bam_ProcessInstanceLog (
        id number(19,0) not null,
        processInstanceId number(19,0),
        processId varchar2(255),
        START_DATE date,
        END_DATE date,
        primary key (id)
    );

