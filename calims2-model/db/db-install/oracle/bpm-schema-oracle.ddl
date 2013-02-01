
    create table bpm_EventTypes (
        InstanceId number(19,0) not null,
        element varchar2(255)
    );

    create table bpm_ProcessInstanceEventInfo (
        id number(19,0) not null,
        eventType varchar2(255),
        processInstanceId number(19,0) not null,
        OPTLOCK number(10,0),
        primary key (id)
    );

    create table bpm_ProcessInstanceInfo (
        InstanceId number(19,0) not null,
        externalVariables number(1,0) not null,
        lastModificationDate date,
        lastReadDate date,
        processId varchar2(255),
        processInstanceByteArray blob,
        startDate date,
        state number(10,0) not null,
        OPTLOCK number(10,0),
        primary key (InstanceId)
    );

    create table bpm_SessionInfo (
        id number(10,0) not null,
        lastModificationDate date,
        rulesByteArray blob,
        startDate date,
        OPTLOCK number(10,0),
        primary key (id)
    );

    create table bpm_VariableInstanceInfo (
        TYPE varchar2(50) not null,
        id number(19,0) not null,
        name varchar2(255),
        persister varchar2(255),
        processInstanceId number(19,0),
        workItemId number(19,0),
        entityClass varchar2(255),
        entityId raw(255),
        content blob,
        primary key (id)
    );

    create table bpm_WorkItemInfo (
        workItemId number(19,0) not null,
        creationDate date,
        externalVariables number(1,0) not null,
        name varchar2(255),
        processInstanceId number(19,0) not null,
        state number(19,0) not null,
        OPTLOCK number(10,0),
        workItemByteArray blob,
        primary key (workItemId)
    );

    alter table bpm_EventTypes 
        add constraint FK8A1287F82849DA 
        foreign key (InstanceId) 
        references bpm_ProcessInstanceInfo;

    alter table bpm_VariableInstanceInfo 
        add constraint FK5DE3E9FFF8EDED9 
        foreign key (workItemId) 
        references bpm_WorkItemInfo;

    alter table bpm_VariableInstanceInfo 
        add constraint FK5DE3E9FF85916989 
        foreign key (processInstanceId) 
        references bpm_ProcessInstanceInfo;

