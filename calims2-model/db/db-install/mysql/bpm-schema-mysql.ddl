
    create table bpm_EventTypes (
        InstanceId bigint not null,
        element varchar(255)
    );

    create table bpm_ProcessInstanceEventInfo (
        id bigint not null auto_increment,
        eventType varchar(255),
        processInstanceId bigint not null,
        OPTLOCK integer,
        primary key (id)
    );

    create table bpm_ProcessInstanceInfo (
        InstanceId bigint not null auto_increment,
        externalVariables bit not null,
        lastModificationDate datetime,
        lastReadDate datetime,
        processId varchar(255),
        processInstanceByteArray longblob,
        startDate datetime,
        state integer not null,
        OPTLOCK integer,
        primary key (InstanceId)
    );

    create table bpm_SessionInfo (
        id integer not null auto_increment,
        lastModificationDate datetime,
        rulesByteArray longblob,
        startDate datetime,
        OPTLOCK integer,
        primary key (id)
    );

    create table bpm_VariableInstanceInfo (
        TYPE varchar(50) not null,
        id bigint not null auto_increment,
        name varchar(255),
        persister varchar(255),
        processInstanceId bigint,
        workItemId bigint,
        entityClass varchar(255),
        entityId tinyblob,
        content longblob,
        primary key (id)
    );

    create table bpm_WorkItemInfo (
        workItemId bigint not null auto_increment,
        creationDate datetime,
        externalVariables bit not null,
        name varchar(255),
        processInstanceId bigint not null,
        state bigint not null,
        OPTLOCK integer,
        workItemByteArray longblob,
        primary key (workItemId)
    );

    alter table bpm_EventTypes 
        add index FK8A1287F82849DA (InstanceId), 
        add constraint FK8A1287F82849DA 
        foreign key (InstanceId) 
        references bpm_ProcessInstanceInfo (InstanceId);

    alter table bpm_VariableInstanceInfo 
        add index FK5DE3E9FFF8EDED9 (workItemId), 
        add constraint FK5DE3E9FFF8EDED9 
        foreign key (workItemId) 
        references bpm_WorkItemInfo (workItemId);

    alter table bpm_VariableInstanceInfo 
        add index FK5DE3E9FF85916989 (processInstanceId), 
        add constraint FK5DE3E9FF85916989 
        foreign key (processInstanceId) 
        references bpm_ProcessInstanceInfo (InstanceId);
