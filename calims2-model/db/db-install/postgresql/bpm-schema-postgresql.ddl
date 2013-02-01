
    create table bpm_EventTypes (
        InstanceId int8 not null,
        element varchar(255)
    );

    create table bpm_ProcessInstanceEventInfo (
        id int8 not null,
        eventType varchar(255),
        processInstanceId int8 not null,
        OPTLOCK int4,
        primary key (id)
    );

    create table bpm_ProcessInstanceInfo (
        InstanceId int8 not null,
        externalVariables bool not null,
        lastModificationDate timestamp,
        lastReadDate timestamp,
        processId varchar(255),
        processInstanceByteArray oid,
        startDate timestamp,
        state int4 not null,
        OPTLOCK int4,
        primary key (InstanceId)
    );

    create table bpm_SessionInfo (
        id int4 not null,
        lastModificationDate timestamp,
        rulesByteArray oid,
        startDate timestamp,
        OPTLOCK int4,
        primary key (id)
    );

    create table bpm_VariableInstanceInfo (
        TYPE varchar(50) not null,
        id int8 not null,
        name varchar(255),
        persister varchar(255),
        processInstanceId int8,
        workItemId int8,
        entityClass varchar(255),
        entityId bytea,
        content oid,
        primary key (id)
    );

    create table bpm_WorkItemInfo (
        workItemId int8 not null,
        creationDate timestamp,
        externalVariables bool not null,
        name varchar(255),
        processInstanceId int8 not null,
        state int8 not null,
        OPTLOCK int4,
        workItemByteArray oid,
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

