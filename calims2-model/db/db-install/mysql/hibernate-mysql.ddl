
    create table ACCOUNT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE datetime not null,
        STARTDATE datetime not null,
        STATUS varchar(100) not null,
        LABORATORY_FK bigint not null,
        ORGANIZATION_FK bigint not null,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table ACCOUNTNUMBER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE datetime not null,
        STARTDATE datetime not null,
        STATUS varchar(100) not null,
        VALUE bigint not null,
        ACCOUNT_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table ADAPTER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK bigint,
        FILEFORMATSPECIFICATION_FK bigint,
        DOCUMENT_FK bigint,
        primary key (id)
    );

    create table ADDITIONALORGANISMNAME (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMMENT varchar(100),
        CONTENT varchar(100),
        DATEASSIGNED datetime,
        ISCURRENTNAME bit,
        SOURCE varchar(100),
        TYPE_FK bigint,
        WHOLEORGANISM_FK bigint,
        primary key (id)
    );

    create table ANTIBODY (
        COUNTOFREQUESTS integer,
        ISOTYPE varchar(100),
        RECOMMENDEDDILUTIONRANGE varchar(100),
        ID bigint not null,
        ANTIGEN_FK bigint,
        primary key (ID)
    );

    create table ANTIGEN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COUNTOFREQUESTS bigint,
        USE varchar(100),
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table APPROVAL (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        BILLINGINFORMATION_FK bigint,
        CUSTOMERREQUEST_FK bigint,
        EXPERIMENTALRESULT_FK bigint,
        FINDING_FK bigint,
        INVOICE_FK bigint,
        LABSUPPLY_FK bigint,
        QUOTATION_FK bigint,
        TYPE_FK bigint,
        RUN_FK bigint,
        PROJECT_FK bigint,
        PROCEDURE_FK bigint,
        METHOD_FK bigint,
        BIOCHEMICALREACTIONMIXTURE_FK bigint,
        primary key (id)
    );

    create table APPROVALPOLL (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS integer,
        APPROVAL_FK bigint,
        DIGITALSIGNATURE_FK bigint,
        PERSON_FK bigint,
        primary key (id)
    );

    create table ARTIFICIALSPECIMEN (
        ID bigint not null,
        primary key (ID)
    );

    create table BASEUNIT (
        ID bigint not null,
        primary key (ID)
    );

    create table BILLINGINFORMATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATE datetime,
        STATUS varchar(100) not null,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table BIOCHEMICALREACTIONMIXTURE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table BIOHAZARD (
        ID bigint not null,
        primary key (ID)
    );

    create table BIOSPECIMEN (
        ID bigint not null,
        TAXON_FK bigint,
        TYPE_FK bigint,
        primary key (ID)
    );

    create table CARBOHYDRATE (
        CHEMICALFORMULA varchar(100),
        ORIENTATION varchar(100),
        POLYSACCHARIDEREPEATPATTERN varchar(100),
        POLYSACCHARIDEUNIT varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table CELLSPECIMEN (
        CELLCULTUREGROWTHMEDIUM varchar(100),
        CELLCULTUREGROWTHMEDIUMSUPPLE varchar(100),
        COUNTOFREQUESTS integer,
        MYCOPLASMASTATUS varchar(100),
        PASSAGENUMBER integer,
        TARGETEDMUTATION varchar(100),
        ID bigint not null,
        CONTAINER_FK bigint,
        primary key (ID)
    );

    create table CHEMICALCOMPOUND (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        NDCCODE varchar(100),
        CHEMICALFORMULA varchar(100),
        EXPIRATIONDATE datetime,
        CONTAINER_FK bigint,
        NANOMATERIAL_FK bigint,
        primary key (id)
    );

    create table CLAUSE (
        DTYPE varchar(31) not null,
        id bigint not null auto_increment,
        CLAUSEINDEX integer,
        OPERATOR varchar(100),
        PROPERTYNAME varchar(100),
        PROPERTYTYPE varchar(100),
        VALUE varchar(100),
        QUERY_FK bigint,
        CLAUSE_FK bigint,
        DISJUNCTION_FK bigint,
        CONJUNCTION_FK bigint,
        primary key (id)
    );

    create table COLLABORATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        ROLE_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table CONSENSUSAPPROVAL (
        REQUIREDPOLLCOUNT bigint,
        REQUIREDREVIEWERCOUNT bigint,
        STATUS integer,
        ID bigint not null,
        primary key (ID)
    );

    create table CONTACTINFORMATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        EMAILADDRESS varchar(100),
        RANK integer not null,
        STATUS varchar(100) not null,
        COLLABORATION_FK bigint,
        LABORATORY_FK bigint,
        LOCATION_FK bigint,
        ORGANIZATION_FK bigint,
        PERSON_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table CONTAINER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X integer,
        Y integer,
        ISREUSABLE bit,
        ISTEMPLATE bit,
        STATUS varchar(100),
        CONTAINERTYPE_FK bigint,
        FILLPATTERN_FK bigint,
        LAYOUT_FK bigint,
        LOCATION_FK bigint,
        CONTAINER_FK bigint,
        primary key (id)
    );

    create table CONTAINERSUBCATEGORY (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK bigint,
        primary key (id)
    );

    create table CONTAINERTYPE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPOSITION varchar(100),
        CONTAINERTYPE_FK bigint,
        CONTAINERSUBCATEGORY_FK bigint,
        LAYOUT_FK bigint,
        primary key (id)
    );

    create table CONTRACT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table COORDINATE_FILLPATTERN (
        ID_COORDINATE_FILLPATTERN bigint not null,
        X integer,
        Y integer,
        LIST_INDEX integer not null,
        primary key (ID_COORDINATE_FILLPATTERN, LIST_INDEX)
    );

    create table CUSTOMERREQUEST (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPLETEDDATE datetime,
        EXPIRATIONDATE datetime,
        LABORATORYFINALAPPROVEDATE datetime,
        STATUS varchar(100) not null,
        SUBMISSIONDATE datetime,
        BILLINGINFORMATION_FK bigint,
        ACCOUNT_FK bigint,
        PERSON_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table Characteristics (
        entitytype varchar(30) not null,
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISQUANTITATIVE bit,
        VALUE varchar(100),
        QUANTITY_VALUE varchar(100),
        DATE datetime,
        AFFECTEDPERSON varchar(100),
        GENOTYPESEX varchar(100),
        PHENOTYPESEX varchar(100),
        PERSON_FK bigint,
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        ANTIGEN_FK bigint,
        QUANTITY_STANDARDUNIT_FK bigint,
        QUANTITY_TYPE_FK bigint,
        COATCOLOR_FK bigint,
        CHEMICALCOMPOUND_FK bigint,
        SEQUENCE_FK bigint,
        NUCLEICACID_FK bigint,
        primary key (id)
    );

    create table Collaboration_Laboratory (
        COLLABORATION_ID bigint not null,
        LABORATORY_ID bigint not null,
        primary key (COLLABORATION_ID, LABORATORY_ID)
    );

    create table Collaboration_Person (
        COLLABORATION_ID bigint not null,
        PERSON_ID bigint not null,
        primary key (COLLABORATION_ID, PERSON_ID)
    );

    create table ContainerType_Layout (
        LAYOUT_ID bigint not null,
        CONTAINERTYPE_ID bigint not null,
        primary key (CONTAINERTYPE_ID, LAYOUT_ID)
    );

    create table DATA (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table DIGITALSIGNATURE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        SIGNATURE varchar(100),
        APPROVALPOLL_FK bigint,
        DOCUMENT_FK bigint,
        PERSON_FK bigint,
        primary key (id)
    );

    create table DOCUMENT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDPAGE varchar(100),
        KEYWORDCODE varchar(100),
        KEYWORDTEXT varchar(100),
        STARTPAGE varchar(100),
        STATUS varchar(100) not null,
        TITLE varchar(100),
        UNIVERSALRESOURCELOCATOR varchar(100),
        VERSION varchar(100),
        ACCOUNT_FK bigint,
        BIOCHEMICALREACTIONMIXTURE_FK bigint,
        CHARACTERISTICS_FK bigint,
        CHEMICALCOMPOUND_FK bigint,
        COLLABORATION_FK bigint,
        CONTRACT_FK bigint,
        CUSTOMERREQUEST_FK bigint,
        DATA_FK bigint,
        DIGITALSIGNATURE_FK bigint,
        EQUIPMENT_FK bigint,
        EVENT_FK bigint,
        FILEFORMATSPECIFICATION_FK bigint,
        HAZARD_FK bigint,
        INVOICE_FK bigint,
        LABSUPPLY_FK bigint,
        LOCATION_FK bigint,
        NAMINGCONVENTION_FK bigint,
        ORGANIZATION_FK bigint,
        PERSON_FK bigint,
        PROCEDURE_FK bigint,
        PROJECT_FK bigint,
        QUOTATION_FK bigint,
        SERVICE_FK bigint,
        SPECIMEN_FK bigint,
        UNIT_FK bigint,
        WORKSHEET_FK bigint,
        primary key (id)
    );

    create table ELECTRONICDOCUMENT (
        DIGITALOBJECTIDENTIFIER varchar(100),
        ID bigint not null,
        FILEFORMATSPECIFICATION_FK bigint,
        STORAGESPACE_FK bigint,
        EQUIPMENT_FK bigint,
        primary key (ID)
    );

    create table EQUIPMENT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MODEL varchar(100),
        PROPERTYID varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        LABORATORY_FK bigint not null,
        LOCATION_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table EXPERIMENT (
        STARTDATE datetime,
        STOPDATE datetime,
        TITLE varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table EXPERIMENTALRESULT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table EXTERNALIDENTIFIER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOURCE varchar(100),
        STATUS varchar(100),
        VALUE varchar(100),
        ACCOUNT_FK bigint,
        CUSTOMERREQUEST_FK bigint,
        LABSUPPLY_FK bigint,
        PERSON_FK bigint,
        SEQUENCE_FK bigint,
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table EnvironmentalCondition (
        entitytype varchar(30) not null,
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAXIMUMHUMIDITY varchar(100),
        MEASUREDHUMIDITY varchar(100),
        MINIMUMHUMIDITY varchar(100),
        MAXIMUMTEMPERATURE float,
        MEASUREDTEMPERATURE float,
        MINIMUMTEMPERATURE float,
        MAXIMUMPH bigint,
        MEASUREDPH bigint,
        MINIMUMPH bigint,
        MAXIMUMPERCENTCO2 float,
        MEASUREDPERCENTCO2 float,
        MINIMUMPERCENTCO2 float,
        MAXIMUMPERCENTO2 float,
        MEASUREDPERCENTO2 float,
        MINIMUMPERCENTO2 float,
        EVENT_FK bigint,
        TYPE_FK bigint,
        BIOCHEMICALREACTIONMIXTURE_FK bigint,
        primary key (id)
    );

    create table Equipment_Hazard (
        EQUIPMENT_ID bigint not null,
        HAZARD_ID bigint not null,
        primary key (EQUIPMENT_ID, HAZARD_ID)
    );

    create table Equipment_Organization (
        EQUIPMENT_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (EQUIPMENT_ID, ORGANIZATION_ID)
    );

    create table Equipment_Person (
        EQUIPMENT_ID bigint not null,
        PERSON_ID bigint not null,
        primary key (EQUIPMENT_ID, PERSON_ID)
    );

    create table Event (
        entitytype varchar(30) not null,
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(100),
        DISPLAYNAME varchar(100),
        NAME varchar(100),
        CONTAINER_FK bigint,
        LABSUPPLY_FK bigint,
        LOCATION_FK bigint,
        PERSON_FK bigint,
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        WHOLEORGANISM_FK bigint,
        ORGANIZATION_FK bigint,
        BIOCHEMICALREACTIONMIXTURE_FK bigint,
        primary key (id)
    );

    create table FEATURE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SEQUENCEEND bigint,
        SEQUENCESTART bigint,
        SITE varchar(100),
        ANTIGEN_FK bigint,
        TYPE_FK bigint,
        SPECIMEN_FK bigint,
        FEATURECOLLECTION_FK bigint,
        primary key (id)
    );

    create table FILEEXTENSION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VALUE varchar(100),
        ELECTRONICDOCUMENT_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table FILEFORMATSPECIFICATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK bigint,
        FILEEXTENSION_FK bigint,
        FILETRANSPORTER_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table FILETRANSPORTER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        primary key (id)
    );

    create table FILLEDREPORT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXECUTEDBY varchar(100),
        EXECUTIONTIME datetime,
        DOCUMENT_FK bigint,
        REPORT_FK bigint,
        primary key (id)
    );

    create table FILLPATTERN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        PERSON_FK bigint,
        LAYOUT_FK bigint,
        primary key (id)
    );

    create table FINDING (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table FLUIDSPECIMEN (
        PREPARATION varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table HAZARD (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTAINER_FK bigint,
        LABSUPPLY_FK bigint,
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table INVOICE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        INVOICEDATE datetime,
        INVOICEPAYMENTDATE datetime,
        STATUS varchar(100) not null,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table Invoice_CustomerRequest (
        INVOICE_ID bigint not null,
        CUSTOMERREQUEST_ID bigint not null,
        primary key (INVOICE_ID, CUSTOMERREQUEST_ID)
    );

    create table LABORATORY (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        LOCATION_FK bigint,
        primary key (id)
    );

    create table LABORATORYOPERATION (
        ID bigint not null,
        primary key (ID)
    );

    create table LABSUPPLY (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE datetime,
        STATUS varchar(100),
        CONTAINER_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table LAYOUT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X_DIMENSION integer,
        X_DIMENSIONLABEL varchar(100) not null,
        Y_DIMENSION integer,
        Y_DIMENSIONLABEL varchar(100) not null,
        PERSON_FK bigint,
        primary key (id)
    );

    create table LIPID (
        CATEGORY varchar(100),
        CHEMICALFORMULA varchar(100),
        DELTAXNOMENCLATURE varchar(100),
        FUNCTION varchar(100),
        NXNOMENCLATURE varchar(100),
        SATURATION varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table LOCATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        VALUE varchar(100),
        LOCATION_FK bigint,
        TYPE_FK bigint not null,
        TRAVELHISTORY_FK bigint,
        primary key (id)
    );

    create table LabSupply_Organization (
        LABSUPPLY_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (LABSUPPLY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Organization (
        LABORATORY_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (LABORATORY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Person (
        LABORATORY_ID bigint not null,
        PERSON_ID bigint not null,
        primary key (LABORATORY_ID, PERSON_ID)
    );

    create table METHOD (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISTEMPLATE bit,
        ORDEROFEXECUTION bigint,
        STATUS integer,
        TYPE_FK bigint,
        PROJECT_FK bigint,
        primary key (id)
    );

    create table MOLECULARSPECIMEN (
        ID bigint not null,
        primary key (ID)
    );

    create table NAMINGCONVENTION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXAMPLE varchar(100),
        GROUPING varchar(100),
        ISMANDATORY bit,
        ISSUGGESTED bit,
        ISUNIQUE bit,
        MAXIMUMLENGTH bigint,
        STATUS varchar(100) not null,
        TYPE integer not null,
        PERSON_FK bigint,
        LABORATORY_FK bigint,
        primary key (id)
    );

    create table NANOMATERIAL (
        ID bigint not null,
        CHEMICALCOMPOUND_FK bigint,
        primary key (ID)
    );

    create table NOTES_ACCOUNT (
        ID_NOTES_ACCOUNT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_ACCOUNTNUMBER (
        ID_NOTES_ACCOUNTNUMBER bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_ADAPTER (
        ID_NOTES_ADAPTER bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_ADDITIONALORGANISMN (
        ID_NOTES_ADDITIONALORGANI bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_APPROVAL (
        ID_NOTES_APPROVAL bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_APPROVALPOLL (
        ID_NOTES_APPROVALPOLL bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_BILLINGINFORMATION (
        ID_NOTES_BILLINGINFORMATI bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_BIOCHEMICALREACTION (
        ID_NOTES_BIOCHEMICALREACT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_CHARACTERISTICS (
        ID_NOTES_CHARACTERISTICS bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_CONTACTINFORMATION (
        ID_NOTES_CONTACTINFORMATI bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_CUSTOMERREQUEST (
        ID_NOTES_CUSTOMERREQUEST bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_DATA (
        ID_NOTES_DATA bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_DIGITALSIGNATURE (
        ID_NOTES_DIGITALSIGNATURE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_EVENT (
        ID_NOTES_EVENT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_EXPERIMENTALRESULT (
        ID_NOTES_EXPERIMENTALRESU bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_FINDING (
        ID_NOTES_FINDING bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_HAZARD (
        ID_NOTES_HAZARD bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_INVOICE (
        ID_NOTES_INVOICE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_LABSUPPLY (
        ID_NOTES_LABSUPPLY bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_LAYOUT (
        ID_NOTES_LAYOUT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_METHOD (
        ID_NOTES_METHOD bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_PARAMETER (
        ID_NOTES_PARAMETER bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_POSTALADDRESS (
        ID_NOTES_POSTALADDRESS bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_PROCEDURE (
        ID_NOTES_PROCEDURE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_PROJECT (
        ID_NOTES_PROJECT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_QUOTATION (
        ID_NOTES_QUOTATION bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_RATE (
        ID_NOTES_RATE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_ROLE (
        ID_NOTES_ROLE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_RUN (
        ID_NOTES_RUN bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SAFETYCAUTION (
        ID_NOTES_SAFETYCAUTION bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SERVICE (
        ID_NOTES_SERVICE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SERVICEITEM (
        ID_NOTES_SERVICEITEM bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SOFTWARE (
        ID_NOTES_SOFTWARE bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SOP (
        ID_NOTES_SOP bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_SPECIMEN (
        ID_NOTES_SPECIMEN bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_STRAIN (
        ID_NOTES_STRAIN bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_TAXON (
        ID_NOTES_TAXON bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NOTES_WORKFLOWEVENT (
        ID_NOTES_WORKFLOWEVENT bigint not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED datetime,
        STATUS varchar(100)
    );

    create table NUCLEICACID (
        ID bigint not null,
        primary key (ID)
    );

    create table ORGANIZATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DUNSNUMBER varchar(100),
        IDENTIFIERNUMBER varchar(100),
        ISTAXEXEMPT bit,
        LEGALCATEGORYTYPE varchar(100),
        STATUS varchar(100) not null,
        TAXIDENTIFIERNUMBER varchar(100),
        LOCATION_FK bigint,
        ORGANIZATION_FK bigint,
        TYPE_FK bigint not null,
        COLLABORATION_FK bigint,
        primary key (id)
    );

    create table PARAMETER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        SPECIMEN_FK bigint,
        TYPE_FK bigint,
        PROCEDURE_FK bigint,
        METHOD_FK bigint,
        SOFTWARE_FK bigint,
        primary key (id)
    );

    create table PCRPRODUCT (
        EXPECTEDSIZE bigint,
        OBSERVEDSIZE bigint,
        ID bigint not null,
        FORWARDPRIMER_FK bigint,
        REVERSEPRIMER_FK bigint,
        primary key (ID)
    );

    create table PERSON (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        USMILITARYRANKPREFIX varchar(100),
        ACADEMICDEGREE varchar(100),
        CERTIFICATION varchar(100),
        CLINICALLICENSE varchar(100),
        DISPLAYNAME varchar(100),
        FAMILYNAME varchar(100),
        GIVENNAME varchar(100),
        INDIVIDUALGENEOLOGYSUFFIX varchar(100),
        MAIDENNAME varchar(100),
        MIDDLENAME varchar(100),
        NAMEPREFIX varchar(100),
        STATUS varchar(100) not null,
        SUFFIX varchar(100),
        TITLE varchar(100),
        TRAININGANDEDUCATIONSUFFIXABR varchar(100),
        USERNAME varchar(100),
        EXTERNALIDENTIFIER_FK bigint,
        PERSONBILLINGINFORMATION_FK bigint,
        SERVICEITEMBILLINGINFORMATION_FK bigint,
        LABSUPPLY_FK bigint,
        primary key (id)
    );

    create table POSTALADDRESS (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ADDRESSSTREETPOSTDIRECTIONALT varchar(100),
        ADDRESSSTREETPREDIRECTIONALTY varchar(100),
        CITY varchar(100),
        COUNTRY varchar(100),
        COUNTY varchar(100),
        FIRSTADDRESSLINE varchar(100),
        MAILSTOPCODE varchar(100),
        POSTOFFICEBOXNUMBER varchar(100),
        POSTALCODE varchar(100),
        SECONDADDRESSLINE varchar(100),
        STATE varchar(100),
        STATUS varchar(100) not null,
        CONTACTINFORMATION_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table PRIMARYDATA (
        ID bigint not null,
        primary key (ID)
    );

    create table PRIMER (
        ID bigint not null,
        primary key (ID)
    );

    create table PROCEDURE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISTEMPLATE bit,
        ORDEROFEXECUTION bigint,
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table PROCESSEDDATA (
        ID bigint not null,
        EXPERIMENTALRESULT_FK bigint,
        PRIMARYDATA_FK bigint,
        primary key (ID)
    );

    create table PROJECT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ACTUALENDDATE datetime,
        ACTUALSTARTDATE datetime,
        EXPECTEDENDDATE datetime,
        EXPECTEDSTARTDATE datetime,
        ISTEMPLATE bit,
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table PROTEIN (
        CLASSGROUP varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table PROTOCOL (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS integer,
        VERSION varchar(100),
        primary key (id)
    );

    create table Person_Organization (
        PERSON_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (PERSON_ID, ORGANIZATION_ID)
    );

    create table ProcessedData_Finding (
        PROCESSEDDATA_ID bigint not null,
        FINDING_ID bigint not null,
        primary key (FINDING_ID, PROCESSEDDATA_ID)
    );

    create table QUANTITY_BIOCHEMICALREACT (
        ID_QUANTITY_BIOCHEMICALRE bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUANTITY_CENTRIFUGATIONEV (
        ID_QUANTITY_CENTRIFUGATIO bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUANTITY_CONTAINER (
        ID_QUANTITY_CONTAINER bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUANTITY_ENVIRONMENTALCON (
        ID_QUANTITY_ENVIRONMENTAL bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUANTITY_LABSUPPLY (
        ID_QUANTITY_LABSUPPLY bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUANTITY_SPECIMEN (
        ID_QUANTITY_SPECIMEN bigint not null,
        STANDARDUNIT_FK bigint,
        TYPE_FK bigint,
        VALUE varchar(100)
    );

    create table QUERY (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAINENTITY varchar(100),
        TYPE_FK bigint,
        primary key (id)
    );

    create table QUOTATION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        APPROVALDATE datetime,
        EXPIRATIONDATE datetime,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        QUANTITY_STANDARDUNIT_FK bigint,
        QUANTITY_TYPE_FK bigint,
        RATE_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table RATE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        PERSON_FK bigint,
        QUANTITY_STANDARDUNIT_FK bigint,
        QUANTITY_TYPE_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table REPORT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        QUERY_FK bigint,
        REPORTDESIGN_FK bigint,
        primary key (id)
    );

    create table REPORTDESIGN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAINENTITY varchar(100),
        DOCUMENT_FK bigint,
        primary key (id)
    );

    create table REVIEWAPPROVAL (
        STATUS integer,
        ID bigint not null,
        primary key (ID)
    );

    create table ROLE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        TYPE integer not null,
        PERSON_FK bigint,
        ORGANIZATION_FK bigint,
        LABORATORY_FK bigint,
        primary key (id)
    );

    create table RUN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ORDEROFEXECUTION bigint,
        STATUS integer,
        TYPE_FK bigint,
        primary key (id)
    );

    create table SAFETYCAUTION (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HAZARD_FK bigint,
        primary key (id)
    );

    create table SEQUENCE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        ASCIIREPRESENTATION varchar(100),
        PARENTENDOFFSET bigint,
        PARENTSTARTOFFSET bigint,
        STRAND varchar(100),
        ANTIBODY_FK bigint,
        ANTIGEN_FK bigint,
        CTERMINUS_FK bigint,
        PHYSICALCHARACTERISTICS_FK bigint,
        NTERMINUS_FK bigint,
        NUCLEICACID_FK bigint,
        PROTEIN_FK bigint,
        primary key (id)
    );

    create table SEQUENTIALAPPROVAL (
        STATUS integer,
        ID bigint not null,
        primary key (ID)
    );

    create table SERVICE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE datetime,
        ISTEMPLATE bit,
        STARTDATE datetime,
        STATUS varchar(100),
        CUSTOMERREQUEST_FK bigint,
        ORGANIZATION_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table SERVICEITEM (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE datetime,
        QUANTITY_VALUE varchar(100),
        SPECIMENTYPE varchar(100),
        STARTDATE datetime,
        STATUS varchar(100),
        QUANTITY_STANDARDUNIT_FK bigint,
        QUANTITY_TYPE_FK bigint,
        SERVICE_FK bigint,
        RATE_FK bigint,
        TYPE_FK bigint not null,
        primary key (id)
    );

    create table SIMPLEAPPROVAL (
        STATUS integer,
        ID bigint not null,
        primary key (ID)
    );

    create table SMALLMOLECULE (
        CHEMICALFORMULA varchar(100),
        MECHANISMOFACTION varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table SOFTWARE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE datetime,
        NUMBEROFUSERS integer,
        OPERATINGSYSTEM varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        VERSION varchar(100),
        TYPE_FK bigint not null,
        EQUIPMENT_FK bigint,
        primary key (id)
    );

    create table SOP (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        VERSION varchar(100),
        PERSON_FK bigint,
        DOCUMENT_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table SPECIMEN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ACTIVITYSTATUS varchar(100),
        CONDITION varchar(100),
        ISAVAILABLE bit,
        RECEIVEDDATETIME datetime,
        USE varchar(100),
        PERSON_FK bigint,
        CONTAINER_FK bigint,
        SPECIMEN_FK bigint,
        SERVICEITEM_FK bigint,
        primary key (id)
    );

    create table STANDARDUNIT (
        CONVERSIONFACTOR decimal(19,2),
        DATASOURCE varchar(100),
        DATATARGET varchar(100),
        OFFSETVALUE decimal(19,2),
        ID bigint not null,
        BASEUNIT_FK bigint,
        primary key (ID)
    );

    create table STORAGEDEVICE (
        ID bigint not null,
        primary key (ID)
    );

    create table STORAGESPACE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        PERSON_FK bigint not null,
        LOCATION_FK bigint not null,
        LAYOUT_FK bigint,
        TYPE_FK bigint not null,
        STORAGEDEVICE_FK bigint,
        primary key (id)
    );

    create table STRAIN (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ETHNICITY varchar(100),
        ISOLATE varchar(100),
        LINE varchar(100),
        STRAINSUBGROUP varchar(100),
        TAXON_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table SUMMARY (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HEADERLABELLIST varchar(100),
        MAXIMUMCOLUMNCOUNT bigint,
        MAXIMUMROWCOUNT bigint,
        QUERY_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table SafetyCaution_Document (
        SAFETYCAUTION_ID bigint not null,
        DOCUMENT_ID bigint not null,
        primary key (SAFETYCAUTION_ID, DOCUMENT_ID)
    );

    create table SafetyCaution_Person (
        SAFETYCAUTION_ID bigint not null,
        PERSON_ID bigint not null,
        primary key (SAFETYCAUTION_ID, PERSON_ID)
    );

    create table ServiceItem_AccountNumber (
        SERVICEITEM_ID bigint not null,
        ACCOUNTNUMBER_ID bigint not null,
        primary key (SERVICEITEM_ID, ACCOUNTNUMBER_ID)
    );

    create table Specimen_Location (
        SPECIMEN_ID bigint not null,
        LOCATION_ID bigint not null,
        primary key (SPECIMEN_ID, LOCATION_ID)
    );

    create table Specimen_Organization (
        SPECIMEN_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (SPECIMEN_ID, ORGANIZATION_ID)
    );

    create table StorageSpace_Organization (
        STORAGESPACE_ID bigint not null,
        ORGANIZATION_ID bigint not null,
        primary key (STORAGESPACE_ID, ORGANIZATION_ID)
    );

    create table TAXON (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMMONNAME varchar(100),
        ETHNICGROUP varchar(100),
        GENUS varchar(100),
        NCBITAXONOMYID varchar(100),
        POPULATIONGROUP varchar(100),
        SCIENTIFICNAME varchar(100),
        SPECIES varchar(100),
        SPECIESSUBGROUP varchar(100),
        STATUS varchar(100),
        primary key (id)
    );

    create table TELEPHONENUMBER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        RANK varchar(100),
        STATUS varchar(100) not null,
        TELEPHONENUMBEREXTENSION varchar(100),
        VALUE varchar(100),
        CONTACTINFORMATION_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table TISSUESPECIMEN (
        PREPARATION varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table TYPE (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATAELEMENTCOLLECTION varchar(100),
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table UNIFORMRESOURCEIDENTIFIER (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TEXT varchar(100),
        VERSION varchar(100),
        ELECTRONICDOCUMENT_FK bigint,
        primary key (id)
    );

    create table UNIT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK bigint,
        primary key (id)
    );

    create table WHOLEORGANISM (
        COMMONNAME varchar(100),
        ETHNICITYSTRAIN varchar(100),
        ID bigint not null,
        primary key (ID)
    );

    create table WORD (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CHARACTERSET integer not null,
        DELIMITER varchar(100),
        ISINCREMENTED bit,
        MAXIMUMLENGTH integer not null,
        MINIMUMLENGTH integer not null,
        PADCHARACTER varchar(100),
        RANK integer not null,
        STATUS varchar(100) not null,
        NAMINGCONVENTION_FK bigint,
        primary key (id)
    );

    create table WORKFLOWEVENT (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS integer,
        LOCATION_FK bigint,
        TYPE_FK bigint,
        primary key (id)
    );

    create table WORKSHEET (
        id bigint not null auto_increment,
        CREATEDBY varchar(100),
        DATECREATED datetime,
        DATEMODIFIED datetime,
        MODIFIEDBY varchar(100),
        DESCRIPTION longtext,
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOP_FK bigint,
        LABSUPPLY_FK bigint,
        PROJECT_FK bigint,
        PROCEDURE_FK bigint,
        METHOD_FK bigint,
        BIOCHEMICALREACTIONMIXTURE_FK bigint,
        primary key (id)
    );

    alter table ACCOUNT 
        add index ACCOUNTYPE_FK (TYPE_FK), 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table ACCOUNT 
        add index ACCOUNLABORA_FK (LABORATORY_FK), 
        add constraint ACCOUNLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY (id);

    alter table ACCOUNT 
        add index ACCOUNORGANI_FK (ORGANIZATION_FK), 
        add constraint ACCOUNORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table ACCOUNTNUMBER 
        add index ACCOUNTYPE_FK (TYPE_FK), 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table ACCOUNTNUMBER 
        add index ACCOUNACCOUNT_FK (ACCOUNT_FK), 
        add constraint ACCOUNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT (id);

    alter table ADAPTER 
        add index ADAPTER_DOCUMENT_FK (DOCUMENT_FK), 
        add constraint ADAPTER_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT (id);

    alter table ADAPTER 
        add index ADAPTER_PERSON_FK (PERSON_FK), 
        add constraint ADAPTER_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table ADAPTER 
        add index ADAPTER_FILEFORMATS_FK (FILEFORMATSPECIFICATION_FK), 
        add constraint ADAPTER_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION (id);

    alter table ADDITIONALORGANISMNAME 
        add index ADDITITYPE_FK (TYPE_FK), 
        add constraint ADDITITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table ADDITIONALORGANISMNAME 
        add index ADDITIWHOLEO_FK (WHOLEORGANISM_FK), 
        add constraint ADDITIWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM (ID);

    alter table ANTIBODY 
        add index FK_ANTIBODY_PROTEIN (ID), 
        add constraint FK_ANTIBODY_PROTEIN 
        foreign key (ID) 
        references PROTEIN (ID);

    alter table ANTIBODY 
        add index ANTIBODY_ANTIGEN_FK (ANTIGEN_FK), 
        add constraint ANTIBODY_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN (id);

    create index ANTIGENUSE_USE_IDX on ANTIGEN (USE);

    alter table ANTIGEN 
        add index ANTIGETYPE_FK (TYPE_FK), 
        add constraint ANTIGETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table ANTIGEN 
        add index ANTIGEN_SPECIMEN_FK (SPECIMEN_FK), 
        add constraint ANTIGEN_SPECIMEN_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table APPROVAL 
        add index APPROVTYPE_FK (TYPE_FK), 
        add constraint APPROVTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table APPROVAL 
        add index APPROVINVOICE_FK (INVOICE_FK), 
        add constraint APPROVINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE (id);

    alter table APPROVAL 
        add index APPROVBILLIN_FK (BILLINGINFORMATION_FK), 
        add constraint APPROVBILLIN_FK 
        foreign key (BILLINGINFORMATION_FK) 
        references BILLINGINFORMATION (id);

    alter table APPROVAL 
        add index APPROVRUN_FK (RUN_FK), 
        add constraint APPROVRUN_FK 
        foreign key (RUN_FK) 
        references RUN (id);

    alter table APPROVAL 
        add index APPROVPROJECT_FK (PROJECT_FK), 
        add constraint APPROVPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT (id);

    alter table APPROVAL 
        add index APPROVPROCED_FK (PROCEDURE_FK), 
        add constraint APPROVPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE (id);

    alter table APPROVAL 
        add index APPROVFINDING_FK (FINDING_FK), 
        add constraint APPROVFINDING_FK 
        foreign key (FINDING_FK) 
        references FINDING (id);

    alter table APPROVAL 
        add index APPROVBIOCHE_FK (BIOCHEMICALREACTIONMIXTURE_FK), 
        add constraint APPROVBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table APPROVAL 
        add index APPROVMETHOD_FK (METHOD_FK), 
        add constraint APPROVMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD (id);

    alter table APPROVAL 
        add index APPROVQUOTAT_FK (QUOTATION_FK), 
        add constraint APPROVQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION (id);

    alter table APPROVAL 
        add index APPROVLABSUP_FK (LABSUPPLY_FK), 
        add constraint APPROVLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table APPROVAL 
        add index APPROVEXPERI_FK (EXPERIMENTALRESULT_FK), 
        add constraint APPROVEXPERI_FK 
        foreign key (EXPERIMENTALRESULT_FK) 
        references EXPERIMENTALRESULT (id);

    alter table APPROVAL 
        add index APPROVCUSTOM_FK (CUSTOMERREQUEST_FK), 
        add constraint APPROVCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST (id);

    alter table APPROVALPOLL 
        add index APPROVALPOLL_DIGITALSIGN_FK (DIGITALSIGNATURE_FK), 
        add constraint APPROVALPOLL_DIGITALSIGN_FK 
        foreign key (DIGITALSIGNATURE_FK) 
        references DIGITALSIGNATURE (id);

    alter table APPROVALPOLL 
        add index APPROVAPPROV_FK (APPROVAL_FK), 
        add constraint APPROVAPPROV_FK 
        foreign key (APPROVAL_FK) 
        references APPROVAL (id);

    alter table APPROVALPOLL 
        add index APPROVALPOLL_PERSON_FK (PERSON_FK), 
        add constraint APPROVALPOLL_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table ARTIFICIALSPECIMEN 
        add index FK_ARTIFICIALSPECIMEN_SPECIM (ID), 
        add constraint FK_ARTIFICIALSPECIMEN_SPECIM 
        foreign key (ID) 
        references SPECIMEN (id);

    alter table BASEUNIT 
        add index FK_BASEUNIT_UNIT (ID), 
        add constraint FK_BASEUNIT_UNIT 
        foreign key (ID) 
        references UNIT (id);

    alter table BILLINGINFORMATION 
        add index BILLINTYPE_FK (TYPE_FK), 
        add constraint BILLINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table BIOCHEMICALREACTIONMIXTURE 
        add index BIOCHEMICAL_TYPE_FK (TYPE_FK), 
        add constraint BIOCHEMICAL_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table BIOHAZARD 
        add index FK_BIOHAZARD_HAZARD (ID), 
        add constraint FK_BIOHAZARD_HAZARD 
        foreign key (ID) 
        references HAZARD (id);

    alter table BIOSPECIMEN 
        add index BIOSPETYPE_FK (TYPE_FK), 
        add constraint BIOSPETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table BIOSPECIMEN 
        add index FK_BIOSPECIMEN_SPECIMEN (ID), 
        add constraint FK_BIOSPECIMEN_SPECIMEN 
        foreign key (ID) 
        references SPECIMEN (id);

    alter table BIOSPECIMEN 
        add index BIOSPETAXON_FK (TAXON_FK), 
        add constraint BIOSPETAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON (id);

    alter table CARBOHYDRATE 
        add index FK_CARBOHYDRATE_MOLECULARSPE (ID), 
        add constraint FK_CARBOHYDRATE_MOLECULARSPE 
        foreign key (ID) 
        references MOLECULARSPECIMEN (ID);

    alter table CELLSPECIMEN 
        add index FK_CELLSPECIMEN_BIOSPECIMEN (ID), 
        add constraint FK_CELLSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN (ID);

    alter table CELLSPECIMEN 
        add index CELLSPECIMEN_CONTAINER_FK (CONTAINER_FK), 
        add constraint CELLSPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table CHEMICALCOMPOUND 
        add index CHEMCIALCOM_CONTAINER_FK (CONTAINER_FK), 
        add constraint CHEMCIALCOM_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table CHEMICALCOMPOUND 
        add index CHEMICALCOM_NANOMATERIAL_FK (NANOMATERIAL_FK), 
        add constraint CHEMICALCOM_NANOMATERIAL_FK 
        foreign key (NANOMATERIAL_FK) 
        references NANOMATERIAL (ID);

    alter table CLAUSE 
        add index CLAUSEDISJUN_FK (DISJUNCTION_FK), 
        add constraint CLAUSEDISJUN_FK 
        foreign key (DISJUNCTION_FK) 
        references CLAUSE (id);

    alter table CLAUSE 
        add index CLAUSEQUERY_FK (QUERY_FK), 
        add constraint CLAUSEQUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY (id);

    alter table CLAUSE 
        add index NEGATION_CLAUSE_FK (CLAUSE_FK), 
        add constraint NEGATION_CLAUSE_FK 
        foreign key (CLAUSE_FK) 
        references CLAUSE (id);

    alter table CLAUSE 
        add index CLAUSECONJUN_FK (CONJUNCTION_FK), 
        add constraint CLAUSECONJUN_FK 
        foreign key (CONJUNCTION_FK) 
        references CLAUSE (id);

    alter table COLLABORATION 
        add index COLLABTYPE_FK (TYPE_FK), 
        add constraint COLLABTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table COLLABORATION 
        add index COLLABROLE_FK (ROLE_FK), 
        add constraint COLLABROLE_FK 
        foreign key (ROLE_FK) 
        references ROLE (id);

    alter table CONSENSUSAPPROVAL 
        add index FK_CONSENSUSAPPROVAL_APPROVA (ID), 
        add constraint FK_CONSENSUSAPPROVAL_APPROVA 
        foreign key (ID) 
        references APPROVAL (id);

    alter table CONTACTINFORMATION 
        add index CONTACTYPE_FK (TYPE_FK), 
        add constraint CONTACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table CONTACTINFORMATION 
        add index CONTACLOCATI_FK (LOCATION_FK), 
        add constraint CONTACLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table CONTACTINFORMATION 
        add index CONTACCOLLAB_FK (COLLABORATION_FK), 
        add constraint CONTACCOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION (id);

    alter table CONTACTINFORMATION 
        add index CONTACPERSON_FK (PERSON_FK), 
        add constraint CONTACPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table CONTACTINFORMATION 
        add index CONTACLABORA_FK (LABORATORY_FK), 
        add constraint CONTACLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY (id);

    alter table CONTACTINFORMATION 
        add index CONTACORGANI_FK (ORGANIZATION_FK), 
        add constraint CONTACORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table CONTAINER 
        add index CONTAILOCATI_FK (LOCATION_FK), 
        add constraint CONTAILOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table CONTAINER 
        add index CONTAIFILLPA_FK (FILLPATTERN_FK), 
        add constraint CONTAIFILLPA_FK 
        foreign key (FILLPATTERN_FK) 
        references FILLPATTERN (id);

    alter table CONTAINER 
        add index CONTAILAYOUT_FK (LAYOUT_FK), 
        add constraint CONTAILAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT (id);

    alter table CONTAINER 
        add index CONTAICONTAI_FK (CONTAINERTYPE_FK), 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE (id);

    alter table CONTAINER 
        add index CHILDCCONTAI_FK (CONTAINER_FK), 
        add constraint CHILDCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table CONTAINERSUBCATEGORY 
        add index CONTAITYPE_FK (TYPE_FK), 
        add constraint CONTAITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table CONTAINERTYPE 
        add index RELATELAYOUT_FK (LAYOUT_FK), 
        add constraint RELATELAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT (id);

    alter table CONTAINERTYPE 
        add index _CONTAINERTY_FK (CONTAINERTYPE_FK), 
        add constraint _CONTAINERTY_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE (id);

    alter table CONTAINERTYPE 
        add index CONTAICONTAI_FK (CONTAINERSUBCATEGORY_FK), 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERSUBCATEGORY_FK) 
        references CONTAINERSUBCATEGORY (id);

    alter table COORDINATE_FILLPATTERN 
        add index FK_COORDINATE_FILLPATTERN (ID_COORDINATE_FILLPATTERN), 
        add constraint FK_COORDINATE_FILLPATTERN 
        foreign key (ID_COORDINATE_FILLPATTERN) 
        references FILLPATTERN (id);

    alter table CUSTOMERREQUEST 
        add index CUSTOMTYPE_FK (TYPE_FK), 
        add constraint CUSTOMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table CUSTOMERREQUEST 
        add index CUSTOMBILLIN_FK (BILLINGINFORMATION_FK), 
        add constraint CUSTOMBILLIN_FK 
        foreign key (BILLINGINFORMATION_FK) 
        references BILLINGINFORMATION (id);

    alter table CUSTOMERREQUEST 
        add index CUSTOMERREQ_PERSON_FK (PERSON_FK), 
        add constraint CUSTOMERREQ_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table CUSTOMERREQUEST 
        add index CUSTOMACCOUNT_FK (ACCOUNT_FK), 
        add constraint CUSTOMACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT (id);

    alter table Characteristics 
        add index QUANTITYPE_FK (QUANTITY_TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE (id);

    alter table Characteristics 
        add index CHARACTYPE_FK (TYPE_FK), 
        add constraint CHARACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table Characteristics 
        add index BODYRECOATCO_FK (COATCOLOR_FK), 
        add constraint BODYRECOATCO_FK 
        foreign key (COATCOLOR_FK) 
        references Characteristics (id);

    alter table Characteristics 
        add index PHYSICNUCLEI_FK (NUCLEICACID_FK), 
        add constraint PHYSICNUCLEI_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID (ID);

    alter table Characteristics 
        add index CHEMICSEQUEN_FK (SEQUENCE_FK), 
        add constraint CHEMICSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE (id);

    alter table Characteristics 
        add index CHARACSPECIM_FK (SPECIMEN_FK), 
        add constraint CHARACSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table Characteristics 
        add index QUANTITY_STANDARDUNIT_FK (QUANTITY_STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table Characteristics 
        add index BIOCHAANTIGEN_FK (ANTIGEN_FK), 
        add constraint BIOCHAANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN (id);

    alter table Characteristics 
        add index FAMILYHISTO_PERSON_FK (PERSON_FK), 
        add constraint FAMILYHISTO_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table Characteristics 
        add index PHYSICCHEMIC_FK (CHEMICALCOMPOUND_FK), 
        add constraint PHYSICCHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND (id);

    alter table Collaboration_Laboratory 
        add index LABORATORY_COLLABORATIO_ID (LABORATORY_ID), 
        add constraint LABORATORY_COLLABORATIO_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY (id);

    alter table Collaboration_Laboratory 
        add index COLLABORATIO_LABORATORY_ID (COLLABORATION_ID), 
        add constraint COLLABORATIO_LABORATORY_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION (id);

    alter table Collaboration_Person 
        add index PERSON_COLLABORATIO_ID (PERSON_ID), 
        add constraint PERSON_COLLABORATIO_ID 
        foreign key (PERSON_ID) 
        references PERSON (id);

    alter table Collaboration_Person 
        add index COLLABORATIO_PERSON_ID (COLLABORATION_ID), 
        add constraint COLLABORATIO_PERSON_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION (id);

    alter table ContainerType_Layout 
        add index CONTAINERTYP_LAYOUT_ID (CONTAINERTYPE_ID), 
        add constraint CONTAINERTYP_LAYOUT_ID 
        foreign key (CONTAINERTYPE_ID) 
        references CONTAINERTYPE (id);

    alter table ContainerType_Layout 
        add index LAYOUT_CONTAINERTYP_ID (LAYOUT_ID), 
        add constraint LAYOUT_CONTAINERTYP_ID 
        foreign key (LAYOUT_ID) 
        references LAYOUT (id);

    alter table DATA 
        add index DATATYPE_FK (TYPE_FK), 
        add constraint DATATYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table DIGITALSIGNATURE 
        add index DIGITALSIGN_DOCUMENT_FK (DOCUMENT_FK), 
        add constraint DIGITALSIGN_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT (id);

    alter table DIGITALSIGNATURE 
        add index DIGITALSIGN_PERSON_FK (PERSON_FK), 
        add constraint DIGITALSIGN_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table DIGITALSIGNATURE 
        add index DIGITALSIGN_APPROVALPOLL_FK (APPROVALPOLL_FK), 
        add constraint DIGITALSIGN_APPROVALPOLL_FK 
        foreign key (APPROVALPOLL_FK) 
        references APPROVALPOLL (id);

    alter table DOCUMENT 
        add index IMAGEFILE_DIGITALSIGN_FK (DIGITALSIGNATURE_FK), 
        add constraint IMAGEFILE_DIGITALSIGN_FK 
        foreign key (DIGITALSIGNATURE_FK) 
        references DIGITALSIGNATURE (id);

    alter table DOCUMENT 
        add index DOCUMENAMING_FK (NAMINGCONVENTION_FK), 
        add constraint DOCUMENAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION (id);

    alter table DOCUMENT 
        add index DOCUMEEVENT_FK (EVENT_FK), 
        add constraint DOCUMEEVENT_FK 
        foreign key (EVENT_FK) 
        references Event (id);

    alter table DOCUMENT 
        add index REFERENCE_CHARACTERIS_FK (CHARACTERISTICS_FK), 
        add constraint REFERENCE_CHARACTERIS_FK 
        foreign key (CHARACTERISTICS_FK) 
        references Characteristics (id);

    alter table DOCUMENT 
        add index REFRENCE_HAZARD_FK (HAZARD_FK), 
        add constraint REFRENCE_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD (id);

    alter table DOCUMENT 
        add index DOCUMEPROJECT_FK (PROJECT_FK), 
        add constraint DOCUMEPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT (id);

    alter table DOCUMENT 
        add index DOCUMESERVICE_FK (SERVICE_FK), 
        add constraint DOCUMESERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE (id);

    alter table DOCUMENT 
        add index DOCUMEQUOTAT_FK (QUOTATION_FK), 
        add constraint DOCUMEQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION (id);

    alter table DOCUMENT 
        add index DOCUMELABSUP_FK (LABSUPPLY_FK), 
        add constraint DOCUMELABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table DOCUMENT 
        add index DOCUMECHEMIC_FK (CHEMICALCOMPOUND_FK), 
        add constraint DOCUMECHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND (id);

    alter table DOCUMENT 
        add index DOCUMECUSTOM_FK (CUSTOMERREQUEST_FK), 
        add constraint DOCUMECUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST (id);

    alter table DOCUMENT 
        add index DOCUMELOCATI_FK (LOCATION_FK), 
        add constraint DOCUMELOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table DOCUMENT 
        add index DOCUMESPECIM_FK (SPECIMEN_FK), 
        add constraint DOCUMESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table DOCUMENT 
        add index DOCUMEINVOICE_FK (INVOICE_FK), 
        add constraint DOCUMEINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE (id);

    alter table DOCUMENT 
        add index DOCUMECOLLAB_FK (COLLABORATION_FK), 
        add constraint DOCUMECOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION (id);

    alter table DOCUMENT 
        add index DOCUMEWORKSH_FK (WORKSHEET_FK), 
        add constraint DOCUMEWORKSH_FK 
        foreign key (WORKSHEET_FK) 
        references WORKSHEET (id);

    alter table DOCUMENT 
        add index DOCUMEPERSON_FK (PERSON_FK), 
        add constraint DOCUMEPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table DOCUMENT 
        add index DOCUMEORGANI_FK (ORGANIZATION_FK), 
        add constraint DOCUMEORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table DOCUMENT 
        add index DOCUMENT_FILEFORMATS_FK (FILEFORMATSPECIFICATION_FK), 
        add constraint DOCUMENT_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION (id);

    alter table DOCUMENT 
        add index DOCUMEPROCED_FK (PROCEDURE_FK), 
        add constraint DOCUMEPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE (id);

    alter table DOCUMENT 
        add index DOCUMEBIOCHE_FK (BIOCHEMICALREACTIONMIXTURE_FK), 
        add constraint DOCUMEBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table DOCUMENT 
        add index DOCUMEEQUIPM_FK (EQUIPMENT_FK), 
        add constraint DOCUMEEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT (id);

    alter table DOCUMENT 
        add index DOCUMECONTRA_FK (CONTRACT_FK), 
        add constraint DOCUMECONTRA_FK 
        foreign key (CONTRACT_FK) 
        references CONTRACT (id);

    alter table DOCUMENT 
        add index DOCUMEACCOUNT_FK (ACCOUNT_FK), 
        add constraint DOCUMEACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT (id);

    alter table DOCUMENT 
        add index DOCUMEDATA_FK (DATA_FK), 
        add constraint DOCUMEDATA_FK 
        foreign key (DATA_FK) 
        references DATA (id);

    alter table DOCUMENT 
        add index REFERENCE_UNIT_FK (UNIT_FK), 
        add constraint REFERENCE_UNIT_FK 
        foreign key (UNIT_FK) 
        references UNIT (id);

    alter table ELECTRONICDOCUMENT 
        add index MANUALEQUIPM_FK (EQUIPMENT_FK), 
        add constraint MANUALEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT (id);

    alter table ELECTRONICDOCUMENT 
        add index FK_ELECTRONICDOCUMENT_DOCUME (ID), 
        add constraint FK_ELECTRONICDOCUMENT_DOCUME 
        foreign key (ID) 
        references DOCUMENT (id);

    alter table ELECTRONICDOCUMENT 
        add index MANUALSTORAG_FK (STORAGESPACE_FK), 
        add constraint MANUALSTORAG_FK 
        foreign key (STORAGESPACE_FK) 
        references STORAGESPACE (id);

    alter table ELECTRONICDOCUMENT 
        add index FILE_FILEFORMATS_FK (FILEFORMATSPECIFICATION_FK), 
        add constraint FILE_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION (id);

    alter table EQUIPMENT 
        add index EQUIPMTYPE_FK (TYPE_FK), 
        add constraint EQUIPMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table EQUIPMENT 
        add index EQUIPMENT_LOCATION_FK (LOCATION_FK), 
        add constraint EQUIPMENT_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table EQUIPMENT 
        add index EQUIPMLABORA_FK (LABORATORY_FK), 
        add constraint EQUIPMLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY (id);

    alter table EXPERIMENT 
        add index FK_EXPERIMENT_METHOD (ID), 
        add constraint FK_EXPERIMENT_METHOD 
        foreign key (ID) 
        references METHOD (id);

    alter table EXPERIMENTALRESULT 
        add index EXPERIMENTA_TYPE_FK (TYPE_FK), 
        add constraint EXPERIMENTA_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNTYPE_FK (TYPE_FK), 
        add constraint EXTERNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNSPECIM_FK (SPECIMEN_FK), 
        add constraint EXTERNSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNSEQUEN_FK (SEQUENCE_FK), 
        add constraint EXTERNSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNALIDE_PERSON_FK (PERSON_FK), 
        add constraint EXTERNALIDE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNLABSUP_FK (LABSUPPLY_FK), 
        add constraint EXTERNLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNACCOUNT_FK (ACCOUNT_FK), 
        add constraint EXTERNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT (id);

    alter table EXTERNALIDENTIFIER 
        add index EXTERNCUSTOM_FK (CUSTOMERREQUEST_FK), 
        add constraint EXTERNCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST (id);

    alter table EnvironmentalCondition 
        add index ENVIROTYPE_FK (TYPE_FK), 
        add constraint ENVIROTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table EnvironmentalCondition 
        add index ENVIROBIOCHE_FK (BIOCHEMICALREACTIONMIXTURE_FK), 
        add constraint ENVIROBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table EnvironmentalCondition 
        add index ENVIROEVENT_FK (EVENT_FK), 
        add constraint ENVIROEVENT_FK 
        foreign key (EVENT_FK) 
        references Event (id);

    alter table Equipment_Hazard 
        add index EQUIPMENT_HAZARD_ID (EQUIPMENT_ID), 
        add constraint EQUIPMENT_HAZARD_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT (id);

    alter table Equipment_Hazard 
        add index HAZARD_EQUIPMENT_ID (HAZARD_ID), 
        add constraint HAZARD_EQUIPMENT_ID 
        foreign key (HAZARD_ID) 
        references HAZARD (id);

    alter table Equipment_Organization 
        add index ORGANIZATION_EQUIPMENT_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_EQUIPMENT_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table Equipment_Organization 
        add index EQUIPMENT_ORGANIZATION_ID (EQUIPMENT_ID), 
        add constraint EQUIPMENT_ORGANIZATION_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT (id);

    alter table Equipment_Person 
        add index EQUIPMENT_PERSON_ID (EQUIPMENT_ID), 
        add constraint EQUIPMENT_PERSON_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT (id);

    alter table Equipment_Person 
        add index PERSON_EQUIPMENT_ID (PERSON_ID), 
        add constraint PERSON_EQUIPMENT_ID 
        foreign key (PERSON_ID) 
        references PERSON (id);

    alter table Event 
        add index EVENTCTYPE_FK (TYPE_FK), 
        add constraint EVENTCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table Event 
        add index EVENTCBIOCHE_FK (BIOCHEMICALREACTIONMIXTURE_FK), 
        add constraint EVENTCBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table Event 
        add index EVENTCLOCATI_FK (LOCATION_FK), 
        add constraint EVENTCLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table Event 
        add index EVENTCSPECIM_FK (SPECIMEN_FK), 
        add constraint EVENTCSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table Event 
        add index EVENTCWHOLEO_FK (WHOLEORGANISM_FK), 
        add constraint EVENTCWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM (ID);

    alter table Event 
        add index EVENTCPERSON_FK (PERSON_FK), 
        add constraint EVENTCPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table Event 
        add index EVENTCCONTAI_FK (CONTAINER_FK), 
        add constraint EVENTCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table Event 
        add index EVENTCLABSUP_FK (LABSUPPLY_FK), 
        add constraint EVENTCLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table Event 
        add index EVENTCORGANI_FK (ORGANIZATION_FK), 
        add constraint EVENTCORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table FEATURE 
        add index FEATURTYPE_FK (TYPE_FK), 
        add constraint FEATURTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table FEATURE 
        add index FEATURSPECIM_FK (SPECIMEN_FK), 
        add constraint FEATURSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table FEATURE 
        add index EPITOPANTIGEN_FK (ANTIGEN_FK), 
        add constraint EPITOPANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN (id);

    alter table FEATURE 
        add index FEATURSEQUEN_FK (FEATURECOLLECTION_FK), 
        add constraint FEATURSEQUEN_FK 
        foreign key (FEATURECOLLECTION_FK) 
        references SEQUENCE (id);

    alter table FILEEXTENSION 
        add index FILEEXTYPE_FK (TYPE_FK), 
        add constraint FILEEXTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table FILEEXTENSION 
        add index FILEEXTENSI_ELECTRONICD_FK (ELECTRONICDOCUMENT_FK), 
        add constraint FILEEXTENSI_ELECTRONICD_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT (ID);

    alter table FILEFORMATSPECIFICATION 
        add index FILEFOTYPE_FK (TYPE_FK), 
        add constraint FILEFOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table FILEFORMATSPECIFICATION 
        add index FILEFOFILETR_FK (FILETRANSPORTER_FK), 
        add constraint FILEFOFILETR_FK 
        foreign key (FILETRANSPORTER_FK) 
        references FILETRANSPORTER (id);

    alter table FILEFORMATSPECIFICATION 
        add index FILEFORMATS_FILEEXTENSI_FK (FILEEXTENSION_FK), 
        add constraint FILEFORMATS_FILEEXTENSI_FK 
        foreign key (FILEEXTENSION_FK) 
        references FILEEXTENSION (id);

    alter table FILEFORMATSPECIFICATION 
        add index FILEFORMATS_PERSON_FK (PERSON_FK), 
        add constraint FILEFORMATS_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table FILLEDREPORT 
        add index FILLEDREPORT_DOCUMENT_FK (DOCUMENT_FK), 
        add constraint FILLEDREPORT_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT (id);

    alter table FILLEDREPORT 
        add index FILLEDREPORT_FK (REPORT_FK), 
        add constraint FILLEDREPORT_FK 
        foreign key (REPORT_FK) 
        references REPORT (id);

    alter table FILLPATTERN 
        add index FILLPALAYOUT_FK (LAYOUT_FK), 
        add constraint FILLPALAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT (id);

    alter table FILLPATTERN 
        add index FILLPATTERN_PERSON_FK (PERSON_FK), 
        add constraint FILLPATTERN_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table FINDING 
        add index FINDING_TYPE_FK (TYPE_FK), 
        add constraint FINDING_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table FLUIDSPECIMEN 
        add index FK_FLUIDSPECIMEN_BIOSPECIMEN (ID), 
        add constraint FK_FLUIDSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN (ID);

    alter table HAZARD 
        add index HAZARDTYPE_FK (TYPE_FK), 
        add constraint HAZARDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table HAZARD 
        add index HAZARDSPECIM_FK (SPECIMEN_FK), 
        add constraint HAZARDSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table HAZARD 
        add index HAZARD_CONTAINER_FK (CONTAINER_FK), 
        add constraint HAZARD_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table HAZARD 
        add index HAZARDLABSUP_FK (LABSUPPLY_FK), 
        add constraint HAZARDLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table INVOICE 
        add index INVOICTYPE_FK (TYPE_FK), 
        add constraint INVOICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table Invoice_CustomerRequest 
        add index INVOICE_CUSTOMERREQU_ID (INVOICE_ID), 
        add constraint INVOICE_CUSTOMERREQU_ID 
        foreign key (INVOICE_ID) 
        references INVOICE (id);

    alter table Invoice_CustomerRequest 
        add index CUSTOMERREQU_INVOICE_ID (CUSTOMERREQUEST_ID), 
        add constraint CUSTOMERREQU_INVOICE_ID 
        foreign key (CUSTOMERREQUEST_ID) 
        references CUSTOMERREQUEST (id);

    alter table LABORATORY 
        add index LABORATORY_LOCATION_FK (LOCATION_FK), 
        add constraint LABORATORY_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table LABORATORYOPERATION 
        add index FK_LABORATORYOPERATION_METHO (ID), 
        add constraint FK_LABORATORYOPERATION_METHO 
        foreign key (ID) 
        references METHOD (id);

    alter table LABSUPPLY 
        add index LABSUPTYPE_FK (TYPE_FK), 
        add constraint LABSUPTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table LABSUPPLY 
        add index LABSUPCONTAI_FK (CONTAINER_FK), 
        add constraint LABSUPCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table LAYOUT 
        add index LAYOUT_PERSON_FK (PERSON_FK), 
        add constraint LAYOUT_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table LIPID 
        add index FK_LIPID_MOLECULARSPECIMEN (ID), 
        add constraint FK_LIPID_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN (ID);

    alter table LOCATION 
        add index LOCATITYPE_FK (TYPE_FK), 
        add constraint LOCATITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table LOCATION 
        add index CHILDLLOCATI_FK (LOCATION_FK), 
        add constraint CHILDLLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table LOCATION 
        add index LOCATITRAVEL_FK (TRAVELHISTORY_FK), 
        add constraint LOCATITRAVEL_FK 
        foreign key (TRAVELHISTORY_FK) 
        references Characteristics (id);

    alter table LabSupply_Organization 
        add index ORGANIZATION_LABSUPPLY_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_LABSUPPLY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table LabSupply_Organization 
        add index LABSUPPLY_ORGANIZATION_ID (LABSUPPLY_ID), 
        add constraint LABSUPPLY_ORGANIZATION_ID 
        foreign key (LABSUPPLY_ID) 
        references LABSUPPLY (id);

    alter table Laboratory_Organization 
        add index ORGANIZATION_LABORATORY_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_LABORATORY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table Laboratory_Organization 
        add index LABORATORY_ORGANIZATION_ID (LABORATORY_ID), 
        add constraint LABORATORY_ORGANIZATION_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY (id);

    alter table Laboratory_Person 
        add index LABORATORY_PERSON_ID (LABORATORY_ID), 
        add constraint LABORATORY_PERSON_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY (id);

    alter table Laboratory_Person 
        add index PERSON_LABORATORY_ID (PERSON_ID), 
        add constraint PERSON_LABORATORY_ID 
        foreign key (PERSON_ID) 
        references PERSON (id);

    alter table METHOD 
        add index METHODTYPE_FK (TYPE_FK), 
        add constraint METHODTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table METHOD 
        add index METHODPROJECT_FK (PROJECT_FK), 
        add constraint METHODPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT (id);

    alter table MOLECULARSPECIMEN 
        add index FK_MOLECULARSPECIMEN_BIOSPEC (ID), 
        add constraint FK_MOLECULARSPECIMEN_BIOSPEC 
        foreign key (ID) 
        references BIOSPECIMEN (ID);

    alter table NAMINGCONVENTION 
        add index NAMINGCONVE_PERSON_FK (PERSON_FK), 
        add constraint NAMINGCONVE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table NAMINGCONVENTION 
        add index NAMINGLABORA_FK (LABORATORY_FK), 
        add constraint NAMINGLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY (id);

    alter table NANOMATERIAL 
        add index FK_NANOMATERIAL_ARTIFICIALSP (ID), 
        add constraint FK_NANOMATERIAL_ARTIFICIALSP 
        foreign key (ID) 
        references ARTIFICIALSPECIMEN (ID);

    alter table NANOMATERIAL 
        add index NANOMATERIAL_CHEMICALCOM_FK (CHEMICALCOMPOUND_FK), 
        add constraint NANOMATERIAL_CHEMICALCOM_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND (id);

    alter table NOTES_ACCOUNT 
        add index FK_NOTES_ACCOUNT (ID_NOTES_ACCOUNT), 
        add constraint FK_NOTES_ACCOUNT 
        foreign key (ID_NOTES_ACCOUNT) 
        references ACCOUNT (id);

    alter table NOTES_ACCOUNTNUMBER 
        add index FK_NOTES_ACCOUNTNUMBER (ID_NOTES_ACCOUNTNUMBER), 
        add constraint FK_NOTES_ACCOUNTNUMBER 
        foreign key (ID_NOTES_ACCOUNTNUMBER) 
        references ACCOUNTNUMBER (id);

    alter table NOTES_ADAPTER 
        add index FK_NOTES_ADAPTER (ID_NOTES_ADAPTER), 
        add constraint FK_NOTES_ADAPTER 
        foreign key (ID_NOTES_ADAPTER) 
        references ADAPTER (id);

    alter table NOTES_ADDITIONALORGANISMN 
        add index FK_NOTES_ADDITIONALORGANI (ID_NOTES_ADDITIONALORGANI), 
        add constraint FK_NOTES_ADDITIONALORGANI 
        foreign key (ID_NOTES_ADDITIONALORGANI) 
        references ADDITIONALORGANISMNAME (id);

    alter table NOTES_APPROVAL 
        add index FK_NOTES_APPROVAL (ID_NOTES_APPROVAL), 
        add constraint FK_NOTES_APPROVAL 
        foreign key (ID_NOTES_APPROVAL) 
        references APPROVAL (id);

    alter table NOTES_APPROVALPOLL 
        add index FK_NOTES_APPROVALPOLL (ID_NOTES_APPROVALPOLL), 
        add constraint FK_NOTES_APPROVALPOLL 
        foreign key (ID_NOTES_APPROVALPOLL) 
        references APPROVALPOLL (id);

    alter table NOTES_BILLINGINFORMATION 
        add index FK_NOTES_BILLINGINFORMATI (ID_NOTES_BILLINGINFORMATI), 
        add constraint FK_NOTES_BILLINGINFORMATI 
        foreign key (ID_NOTES_BILLINGINFORMATI) 
        references BILLINGINFORMATION (id);

    alter table NOTES_BIOCHEMICALREACTION 
        add index FK_NOTES_BIOCHEMICALREACT (ID_NOTES_BIOCHEMICALREACT), 
        add constraint FK_NOTES_BIOCHEMICALREACT 
        foreign key (ID_NOTES_BIOCHEMICALREACT) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table NOTES_CHARACTERISTICS 
        add index FK_NOTES_CHARACTERISTICS (ID_NOTES_CHARACTERISTICS), 
        add constraint FK_NOTES_CHARACTERISTICS 
        foreign key (ID_NOTES_CHARACTERISTICS) 
        references Characteristics (id);

    alter table NOTES_CONTACTINFORMATION 
        add index FK_NOTES_CONTACTINFORMATI (ID_NOTES_CONTACTINFORMATI), 
        add constraint FK_NOTES_CONTACTINFORMATI 
        foreign key (ID_NOTES_CONTACTINFORMATI) 
        references CONTACTINFORMATION (id);

    alter table NOTES_CUSTOMERREQUEST 
        add index FK_NOTES_CUSTOMERREQUEST (ID_NOTES_CUSTOMERREQUEST), 
        add constraint FK_NOTES_CUSTOMERREQUEST 
        foreign key (ID_NOTES_CUSTOMERREQUEST) 
        references CUSTOMERREQUEST (id);

    alter table NOTES_DATA 
        add index FK_NOTES_DATA (ID_NOTES_DATA), 
        add constraint FK_NOTES_DATA 
        foreign key (ID_NOTES_DATA) 
        references DATA (id);

    alter table NOTES_DIGITALSIGNATURE 
        add index FK_NOTES_DIGITALSIGNATURE (ID_NOTES_DIGITALSIGNATURE), 
        add constraint FK_NOTES_DIGITALSIGNATURE 
        foreign key (ID_NOTES_DIGITALSIGNATURE) 
        references DIGITALSIGNATURE (id);

    alter table NOTES_EVENT 
        add index FK_NOTES_EVENT (ID_NOTES_EVENT), 
        add constraint FK_NOTES_EVENT 
        foreign key (ID_NOTES_EVENT) 
        references Event (id);

    alter table NOTES_EXPERIMENTALRESULT 
        add index FK_NOTES_EXPERIMENTALRESU (ID_NOTES_EXPERIMENTALRESU), 
        add constraint FK_NOTES_EXPERIMENTALRESU 
        foreign key (ID_NOTES_EXPERIMENTALRESU) 
        references EXPERIMENTALRESULT (id);

    alter table NOTES_FINDING 
        add index FK_NOTES_FINDING (ID_NOTES_FINDING), 
        add constraint FK_NOTES_FINDING 
        foreign key (ID_NOTES_FINDING) 
        references FINDING (id);

    alter table NOTES_HAZARD 
        add index FK_NOTES_HAZARD (ID_NOTES_HAZARD), 
        add constraint FK_NOTES_HAZARD 
        foreign key (ID_NOTES_HAZARD) 
        references HAZARD (id);

    alter table NOTES_INVOICE 
        add index FK_NOTES_INVOICE (ID_NOTES_INVOICE), 
        add constraint FK_NOTES_INVOICE 
        foreign key (ID_NOTES_INVOICE) 
        references INVOICE (id);

    alter table NOTES_LABSUPPLY 
        add index FK_NOTES_LABSUPPLY (ID_NOTES_LABSUPPLY), 
        add constraint FK_NOTES_LABSUPPLY 
        foreign key (ID_NOTES_LABSUPPLY) 
        references LABSUPPLY (id);

    alter table NOTES_LAYOUT 
        add index FK_NOTES_LAYOUT (ID_NOTES_LAYOUT), 
        add constraint FK_NOTES_LAYOUT 
        foreign key (ID_NOTES_LAYOUT) 
        references LAYOUT (id);

    alter table NOTES_METHOD 
        add index FK_NOTES_METHOD (ID_NOTES_METHOD), 
        add constraint FK_NOTES_METHOD 
        foreign key (ID_NOTES_METHOD) 
        references METHOD (id);

    alter table NOTES_PARAMETER 
        add index FK_NOTES_PARAMETER (ID_NOTES_PARAMETER), 
        add constraint FK_NOTES_PARAMETER 
        foreign key (ID_NOTES_PARAMETER) 
        references PARAMETER (id);

    alter table NOTES_POSTALADDRESS 
        add index FK_NOTES_POSTALADDRESS (ID_NOTES_POSTALADDRESS), 
        add constraint FK_NOTES_POSTALADDRESS 
        foreign key (ID_NOTES_POSTALADDRESS) 
        references POSTALADDRESS (id);

    alter table NOTES_PROCEDURE 
        add index FK_NOTES_PROCEDURE (ID_NOTES_PROCEDURE), 
        add constraint FK_NOTES_PROCEDURE 
        foreign key (ID_NOTES_PROCEDURE) 
        references PROCEDURE (id);

    alter table NOTES_PROJECT 
        add index FK_NOTES_PROJECT (ID_NOTES_PROJECT), 
        add constraint FK_NOTES_PROJECT 
        foreign key (ID_NOTES_PROJECT) 
        references PROJECT (id);

    alter table NOTES_QUOTATION 
        add index FK_NOTES_QUOTATION (ID_NOTES_QUOTATION), 
        add constraint FK_NOTES_QUOTATION 
        foreign key (ID_NOTES_QUOTATION) 
        references QUOTATION (id);

    alter table NOTES_RATE 
        add index FK_NOTES_RATE (ID_NOTES_RATE), 
        add constraint FK_NOTES_RATE 
        foreign key (ID_NOTES_RATE) 
        references RATE (id);

    alter table NOTES_ROLE 
        add index FK_NOTES_ROLE (ID_NOTES_ROLE), 
        add constraint FK_NOTES_ROLE 
        foreign key (ID_NOTES_ROLE) 
        references ROLE (id);

    alter table NOTES_RUN 
        add index FK_NOTES_RUN (ID_NOTES_RUN), 
        add constraint FK_NOTES_RUN 
        foreign key (ID_NOTES_RUN) 
        references RUN (id);

    alter table NOTES_SAFETYCAUTION 
        add index FK_NOTES_SAFETYCAUTION (ID_NOTES_SAFETYCAUTION), 
        add constraint FK_NOTES_SAFETYCAUTION 
        foreign key (ID_NOTES_SAFETYCAUTION) 
        references SAFETYCAUTION (id);

    alter table NOTES_SERVICE 
        add index FK_NOTES_SERVICE (ID_NOTES_SERVICE), 
        add constraint FK_NOTES_SERVICE 
        foreign key (ID_NOTES_SERVICE) 
        references SERVICE (id);

    alter table NOTES_SERVICEITEM 
        add index FK_NOTES_SERVICEITEM (ID_NOTES_SERVICEITEM), 
        add constraint FK_NOTES_SERVICEITEM 
        foreign key (ID_NOTES_SERVICEITEM) 
        references SERVICEITEM (id);

    alter table NOTES_SOFTWARE 
        add index FK_NOTES_SOFTWARE (ID_NOTES_SOFTWARE), 
        add constraint FK_NOTES_SOFTWARE 
        foreign key (ID_NOTES_SOFTWARE) 
        references SOFTWARE (id);

    alter table NOTES_SOP 
        add index FK_NOTES_SOP (ID_NOTES_SOP), 
        add constraint FK_NOTES_SOP 
        foreign key (ID_NOTES_SOP) 
        references SOP (id);

    alter table NOTES_SPECIMEN 
        add index FK_NOTES_SPECIMEN (ID_NOTES_SPECIMEN), 
        add constraint FK_NOTES_SPECIMEN 
        foreign key (ID_NOTES_SPECIMEN) 
        references SPECIMEN (id);

    alter table NOTES_STRAIN 
        add index FK_NOTES_STRAIN (ID_NOTES_STRAIN), 
        add constraint FK_NOTES_STRAIN 
        foreign key (ID_NOTES_STRAIN) 
        references STRAIN (id);

    alter table NOTES_TAXON 
        add index FK_NOTES_TAXON (ID_NOTES_TAXON), 
        add constraint FK_NOTES_TAXON 
        foreign key (ID_NOTES_TAXON) 
        references TAXON (id);

    alter table NOTES_WORKFLOWEVENT 
        add index FK_NOTES_WORKFLOWEVENT (ID_NOTES_WORKFLOWEVENT), 
        add constraint FK_NOTES_WORKFLOWEVENT 
        foreign key (ID_NOTES_WORKFLOWEVENT) 
        references WORKFLOWEVENT (id);

    alter table NUCLEICACID 
        add index FK_NUCLEICACID_MOLECULARSPEC (ID), 
        add constraint FK_NUCLEICACID_MOLECULARSPEC 
        foreign key (ID) 
        references MOLECULARSPECIMEN (ID);

    alter table ORGANIZATION 
        add index ORGANITYPE_FK (TYPE_FK), 
        add constraint ORGANITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table ORGANIZATION 
        add index ORGANIZATION_LOCATION_FK (LOCATION_FK), 
        add constraint ORGANIZATION_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table ORGANIZATION 
        add index ORGANICOLLAB_FK (COLLABORATION_FK), 
        add constraint ORGANICOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION (id);

    alter table ORGANIZATION 
        add index CHILDOORGANI_FK (ORGANIZATION_FK), 
        add constraint CHILDOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table PARAMETER 
        add index PARAMETYPE_FK (TYPE_FK), 
        add constraint PARAMETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table PARAMETER 
        add index PARAMESPECIM_FK (SPECIMEN_FK), 
        add constraint PARAMESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table PARAMETER 
        add index PARAMEMETHOD_FK (METHOD_FK), 
        add constraint PARAMEMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD (id);

    alter table PARAMETER 
        add index PARAMESOFTWA_FK (SOFTWARE_FK), 
        add constraint PARAMESOFTWA_FK 
        foreign key (SOFTWARE_FK) 
        references SOFTWARE (id);

    alter table PARAMETER 
        add index PARAMEPROCED_FK (PROCEDURE_FK), 
        add constraint PARAMEPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE (id);

    alter table PCRPRODUCT 
        add index FK_PCRPRODUCT_NUCLEICACID (ID), 
        add constraint FK_PCRPRODUCT_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID (ID);

    alter table PCRPRODUCT 
        add index PCRPRODUCTB_PRIMER_FK (FORWARDPRIMER_FK), 
        add constraint PCRPRODUCTB_PRIMER_FK 
        foreign key (FORWARDPRIMER_FK) 
        references PRIMER (ID);

    alter table PCRPRODUCT 
        add index PCRPRODUCTA_PRIMER_FK (REVERSEPRIMER_FK), 
        add constraint PCRPRODUCTA_PRIMER_FK 
        foreign key (REVERSEPRIMER_FK) 
        references PRIMER (ID);

    alter table PERSON 
        add index PERSON_EXTERNALIDE_FK (EXTERNALIDENTIFIER_FK), 
        add constraint PERSON_EXTERNALIDE_FK 
        foreign key (EXTERNALIDENTIFIER_FK) 
        references EXTERNALIDENTIFIER (id);

    alter table PERSON 
        add index SERVICBILLIN_FK (SERVICEITEMBILLINGINFORMATION_FK), 
        add constraint SERVICBILLIN_FK 
        foreign key (SERVICEITEMBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION (id);

    alter table PERSON 
        add index PERSONLABSUP_FK (LABSUPPLY_FK), 
        add constraint PERSONLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table PERSON 
        add index PERSONBILLIN_FK (PERSONBILLINGINFORMATION_FK), 
        add constraint PERSONBILLIN_FK 
        foreign key (PERSONBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION (id);

    alter table POSTALADDRESS 
        add index POSTALTYPE_FK (TYPE_FK), 
        add constraint POSTALTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table POSTALADDRESS 
        add index POSTALCONTAC_FK (CONTACTINFORMATION_FK), 
        add constraint POSTALCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION (id);

    alter table PRIMARYDATA 
        add index FK_PRIMARYDATA_DATA (ID), 
        add constraint FK_PRIMARYDATA_DATA 
        foreign key (ID) 
        references DATA (id);

    alter table PRIMER 
        add index FK_PRIMER_NUCLEICACID (ID), 
        add constraint FK_PRIMER_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID (ID);

    alter table PROCEDURE 
        add index PROCEDTYPE_FK (TYPE_FK), 
        add constraint PROCEDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table PROCESSEDDATA 
        add index PROCESPRIMAR_FK (PRIMARYDATA_FK), 
        add constraint PROCESPRIMAR_FK 
        foreign key (PRIMARYDATA_FK) 
        references PRIMARYDATA (ID);

    alter table PROCESSEDDATA 
        add index FK_PROCESSEDDATA_DATA (ID), 
        add constraint FK_PROCESSEDDATA_DATA 
        foreign key (ID) 
        references DATA (id);

    alter table PROCESSEDDATA 
        add index PROCESEXPERI_FK (EXPERIMENTALRESULT_FK), 
        add constraint PROCESEXPERI_FK 
        foreign key (EXPERIMENTALRESULT_FK) 
        references EXPERIMENTALRESULT (id);

    alter table PROJECT 
        add index PROCEDTYPE_FK (TYPE_FK), 
        add constraint PROCEDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table PROTEIN 
        add index FK_PROTEIN_MOLECULARSPECIMEN (ID), 
        add constraint FK_PROTEIN_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN (ID);

    alter table Person_Organization 
        add index ORGANIZATION_PERSON_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_PERSON_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table Person_Organization 
        add index PERSON_ORGANIZATION_ID (PERSON_ID), 
        add constraint PERSON_ORGANIZATION_ID 
        foreign key (PERSON_ID) 
        references PERSON (id);

    alter table ProcessedData_Finding 
        add index PROCESSEDDAT_FINDING_ID (PROCESSEDDATA_ID), 
        add constraint PROCESSEDDAT_FINDING_ID 
        foreign key (PROCESSEDDATA_ID) 
        references PROCESSEDDATA (ID);

    alter table ProcessedData_Finding 
        add index FINDING_PROCESSEDDAT_ID (FINDING_ID), 
        add constraint FINDING_PROCESSEDDAT_ID 
        foreign key (FINDING_ID) 
        references FINDING (id);

    alter table QUANTITY_BIOCHEMICALREACT 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_BIOCHEMICALREACT 
        add index FK_QUANTITY_BIOCHEMICALRE (ID_QUANTITY_BIOCHEMICALRE), 
        add constraint FK_QUANTITY_BIOCHEMICALRE 
        foreign key (ID_QUANTITY_BIOCHEMICALRE) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table QUANTITY_BIOCHEMICALREACT 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUANTITY_CENTRIFUGATIONEV 
        add index FK_QUANTITY_CENTRIFUGATIO (ID_QUANTITY_CENTRIFUGATIO), 
        add constraint FK_QUANTITY_CENTRIFUGATIO 
        foreign key (ID_QUANTITY_CENTRIFUGATIO) 
        references Event (id);

    alter table QUANTITY_CENTRIFUGATIONEV 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_CENTRIFUGATIONEV 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUANTITY_CONTAINER 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_CONTAINER 
        add index FK_QUANTITY_CONTAINER (ID_QUANTITY_CONTAINER), 
        add constraint FK_QUANTITY_CONTAINER 
        foreign key (ID_QUANTITY_CONTAINER) 
        references CONTAINER (id);

    alter table QUANTITY_CONTAINER 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUANTITY_ENVIRONMENTALCON 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_ENVIRONMENTALCON 
        add index FK_QUANTITY_ENVIRONMENTAL (ID_QUANTITY_ENVIRONMENTAL), 
        add constraint FK_QUANTITY_ENVIRONMENTAL 
        foreign key (ID_QUANTITY_ENVIRONMENTAL) 
        references EnvironmentalCondition (id);

    alter table QUANTITY_ENVIRONMENTALCON 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUANTITY_LABSUPPLY 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_LABSUPPLY 
        add index FK_QUANTITY_LABSUPPLY (ID_QUANTITY_LABSUPPLY), 
        add constraint FK_QUANTITY_LABSUPPLY 
        foreign key (ID_QUANTITY_LABSUPPLY) 
        references LABSUPPLY (id);

    alter table QUANTITY_LABSUPPLY 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUANTITY_SPECIMEN 
        add index FK_QUANTITY_SPECIMEN (ID_QUANTITY_SPECIMEN), 
        add constraint FK_QUANTITY_SPECIMEN 
        foreign key (ID_QUANTITY_SPECIMEN) 
        references SPECIMEN (id);

    alter table QUANTITY_SPECIMEN 
        add index QUANTITYPE_FK (TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUANTITY_SPECIMEN 
        add index QUANTITY_STANDARDUNIT_FK (STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table QUERY 
        add index QUERYCTYPE_FK (TYPE_FK), 
        add constraint QUERYCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUOTATION 
        add index QUOTATTYPE_FK (TYPE_FK), 
        add constraint QUOTATTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table QUOTATION 
        add index QUANTITYPE_FK (QUANTITY_TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE (id);

    alter table QUOTATION 
        add index QUOTATION_RATE_FK (RATE_FK), 
        add constraint QUOTATION_RATE_FK 
        foreign key (RATE_FK) 
        references RATE (id);

    alter table QUOTATION 
        add index QUANTITY_STANDARDUNIT_FK (QUANTITY_STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table RATE 
        add index RATECOTYPE_FK (TYPE_FK), 
        add constraint RATECOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table RATE 
        add index QUANTITYPE_FK (QUANTITY_TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE (id);

    alter table RATE 
        add index QUANTITY_STANDARDUNIT_FK (QUANTITY_STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table RATE 
        add index RATE_PERSON_FK (PERSON_FK), 
        add constraint RATE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table REPORT 
        add index REPORTQUERY_FK (QUERY_FK), 
        add constraint REPORTQUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY (id);

    alter table REPORT 
        add index REPORTREPORT_FK (REPORTDESIGN_FK), 
        add constraint REPORTREPORT_FK 
        foreign key (REPORTDESIGN_FK) 
        references REPORTDESIGN (id);

    alter table REPORTDESIGN 
        add index REPORTDESIGN_DOCUMENT_FK (DOCUMENT_FK), 
        add constraint REPORTDESIGN_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT (id);

    alter table REVIEWAPPROVAL 
        add index FK_REVIEWAPPROVAL_APPROVAL (ID), 
        add constraint FK_REVIEWAPPROVAL_APPROVAL 
        foreign key (ID) 
        references APPROVAL (id);

    alter table ROLE 
        add index ROLECOPERSON_FK (PERSON_FK), 
        add constraint ROLECOPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table ROLE 
        add index ROLECOLABORA_FK (LABORATORY_FK), 
        add constraint ROLECOLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY (id);

    alter table ROLE 
        add index ROLECOORGANI_FK (ORGANIZATION_FK), 
        add constraint ROLECOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table RUN 
        add index RUNCOLTYPE_FK (TYPE_FK), 
        add constraint RUNCOLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SAFETYCAUTION 
        add index SAFETYCAUTI_HAZARD_FK (HAZARD_FK), 
        add constraint SAFETYCAUTI_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD (id);

    alter table SEQUENCE 
        add index SEQUENCE_NUCLEICACID_FK (NUCLEICACID_FK), 
        add constraint SEQUENCE_NUCLEICACID_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID (ID);

    alter table SEQUENCE 
        add index SEQUENCEA_FEATURE_FK (NTERMINUS_FK), 
        add constraint SEQUENCEA_FEATURE_FK 
        foreign key (NTERMINUS_FK) 
        references FEATURE (id);

    alter table SEQUENCE 
        add index SEQUENCE_PHYSICALCHA_FK (PHYSICALCHARACTERISTICS_FK), 
        add constraint SEQUENCE_PHYSICALCHA_FK 
        foreign key (PHYSICALCHARACTERISTICS_FK) 
        references Characteristics (id);

    alter table SEQUENCE 
        add index SEQUENCE_ANTIGEN_FK (ANTIGEN_FK), 
        add constraint SEQUENCE_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN (id);

    alter table SEQUENCE 
        add index SEQUENCEB_FEATURE_FK (CTERMINUS_FK), 
        add constraint SEQUENCEB_FEATURE_FK 
        foreign key (CTERMINUS_FK) 
        references FEATURE (id);

    alter table SEQUENCE 
        add index ANTIBODYBIN_ANTIBODY_FK (ANTIBODY_FK), 
        add constraint ANTIBODYBIN_ANTIBODY_FK 
        foreign key (ANTIBODY_FK) 
        references ANTIBODY (ID);

    alter table SEQUENCE 
        add index SEQUENPROTEIN_FK (PROTEIN_FK), 
        add constraint SEQUENPROTEIN_FK 
        foreign key (PROTEIN_FK) 
        references PROTEIN (ID);

    alter table SEQUENTIALAPPROVAL 
        add index FK_SEQUENTIALAPPROVAL_APPROV (ID), 
        add constraint FK_SEQUENTIALAPPROVAL_APPROV 
        foreign key (ID) 
        references APPROVAL (id);

    alter table SERVICE 
        add index SERVICTYPE_FK (TYPE_FK), 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SERVICE 
        add index SERVICORGANI_FK (ORGANIZATION_FK), 
        add constraint SERVICORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION (id);

    alter table SERVICE 
        add index SERVICCUSTOM_FK (CUSTOMERREQUEST_FK), 
        add constraint SERVICCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST (id);

    alter table SERVICEITEM 
        add index SERVICTYPE_FK (TYPE_FK), 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SERVICEITEM 
        add index QUANTITYPE_FK (QUANTITY_TYPE_FK), 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE (id);

    alter table SERVICEITEM 
        add index SERVICEITEM_RATE_FK (RATE_FK), 
        add constraint SERVICEITEM_RATE_FK 
        foreign key (RATE_FK) 
        references RATE (id);

    alter table SERVICEITEM 
        add index QUANTITY_STANDARDUNIT_FK (QUANTITY_STANDARDUNIT_FK), 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT (ID);

    alter table SERVICEITEM 
        add index SERVICSERVICE_FK (SERVICE_FK), 
        add constraint SERVICSERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE (id);

    alter table SIMPLEAPPROVAL 
        add index FK_SIMPLEAPPROVAL_APPROVAL (ID), 
        add constraint FK_SIMPLEAPPROVAL_APPROVAL 
        foreign key (ID) 
        references APPROVAL (id);

    alter table SMALLMOLECULE 
        add index FK_SMALLMOLECULE_MOLECULARSP (ID), 
        add constraint FK_SMALLMOLECULE_MOLECULARSP 
        foreign key (ID) 
        references MOLECULARSPECIMEN (ID);

    alter table SOFTWARE 
        add index SOFTWATYPE_FK (TYPE_FK), 
        add constraint SOFTWATYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SOFTWARE 
        add index SOFTWAEQUIPM_FK (EQUIPMENT_FK), 
        add constraint SOFTWAEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT (id);

    alter table SOP 
        add index SOPCOLTYPE_FK (TYPE_FK), 
        add constraint SOPCOLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SOP 
        add index SOP_DOCUMENT_FK (DOCUMENT_FK), 
        add constraint SOP_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT (id);

    alter table SOP 
        add index SOP_PERSON_FK (PERSON_FK), 
        add constraint SOP_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table SPECIMEN 
        add index CHILDSSPECIM_FK (SPECIMEN_FK), 
        add constraint CHILDSSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN (id);

    alter table SPECIMEN 
        add index SPECIMEN_CONTAINER_FK (CONTAINER_FK), 
        add constraint SPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER (id);

    alter table SPECIMEN 
        add index SPECIMPERSON_FK (PERSON_FK), 
        add constraint SPECIMPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table SPECIMEN 
        add index SPECIMSERVIC_FK (SERVICEITEM_FK), 
        add constraint SPECIMSERVIC_FK 
        foreign key (SERVICEITEM_FK) 
        references SERVICEITEM (id);

    alter table STANDARDUNIT 
        add index FK_STANDARDUNIT_UNIT (ID), 
        add constraint FK_STANDARDUNIT_UNIT 
        foreign key (ID) 
        references UNIT (id);

    alter table STANDARDUNIT 
        add index STANDABASEUN_FK (BASEUNIT_FK), 
        add constraint STANDABASEUN_FK 
        foreign key (BASEUNIT_FK) 
        references BASEUNIT (ID);

    alter table STORAGEDEVICE 
        add index FK_STORAGEDEVICE_EQUIPMENT (ID), 
        add constraint FK_STORAGEDEVICE_EQUIPMENT 
        foreign key (ID) 
        references EQUIPMENT (id);

    alter table STORAGESPACE 
        add index STORAGTYPE_FK (TYPE_FK), 
        add constraint STORAGTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table STORAGESPACE 
        add index STORAGLOCATI_FK (LOCATION_FK), 
        add constraint STORAGLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table STORAGESPACE 
        add index STORAGSTORAG_FK (STORAGEDEVICE_FK), 
        add constraint STORAGSTORAG_FK 
        foreign key (STORAGEDEVICE_FK) 
        references STORAGEDEVICE (ID);

    alter table STORAGESPACE 
        add index STORAGESPACE_LAYOUT_FK (LAYOUT_FK), 
        add constraint STORAGESPACE_LAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT (id);

    alter table STORAGESPACE 
        add index STORAGESPACE_PERSON_FK (PERSON_FK), 
        add constraint STORAGESPACE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON (id);

    alter table STRAIN 
        add index STRAINTYPE_FK (TYPE_FK), 
        add constraint STRAINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table STRAIN 
        add index ORGANISMSTR_TAXON_FK (TAXON_FK), 
        add constraint ORGANISMSTR_TAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON (id);

    alter table SUMMARY 
        add index SUMMARTYPE_FK (TYPE_FK), 
        add constraint SUMMARTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table SUMMARY 
        add index SUMMARY_QUERY_FK (QUERY_FK), 
        add constraint SUMMARY_QUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY (id);

    alter table SafetyCaution_Document 
        add index DOCUMENT_SAFETYCAUTIO_ID (DOCUMENT_ID), 
        add constraint DOCUMENT_SAFETYCAUTIO_ID 
        foreign key (DOCUMENT_ID) 
        references DOCUMENT (id);

    alter table SafetyCaution_Document 
        add index SAFETYCAUTIO_DOCUMENT_ID (SAFETYCAUTION_ID), 
        add constraint SAFETYCAUTIO_DOCUMENT_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION (id);

    alter table SafetyCaution_Person 
        add index PERSON_SAFETYCAUTIO_ID (PERSON_ID), 
        add constraint PERSON_SAFETYCAUTIO_ID 
        foreign key (PERSON_ID) 
        references PERSON (id);

    alter table SafetyCaution_Person 
        add index SAFETYCAUTIO_PERSON_ID (SAFETYCAUTION_ID), 
        add constraint SAFETYCAUTIO_PERSON_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION (id);

    alter table ServiceItem_AccountNumber 
        add index SERVICEITEM_ACCOUNTNUMBE_ID (SERVICEITEM_ID), 
        add constraint SERVICEITEM_ACCOUNTNUMBE_ID 
        foreign key (SERVICEITEM_ID) 
        references SERVICEITEM (id);

    alter table ServiceItem_AccountNumber 
        add index ACCOUNTNUMBE_SERVICEITEM_ID (ACCOUNTNUMBER_ID), 
        add constraint ACCOUNTNUMBE_SERVICEITEM_ID 
        foreign key (ACCOUNTNUMBER_ID) 
        references ACCOUNTNUMBER (id);

    alter table Specimen_Location 
        add index SPECIMEN_LOCATION_ID (SPECIMEN_ID), 
        add constraint SPECIMEN_LOCATION_ID 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN (id);

    alter table Specimen_Location 
        add index LOCATION_SPECIMEN_ID (LOCATION_ID), 
        add constraint LOCATION_SPECIMEN_ID 
        foreign key (LOCATION_ID) 
        references LOCATION (id);

    alter table Specimen_Organization 
        add index ORGANIZATION_SPECIMEN_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_SPECIMEN_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table Specimen_Organization 
        add index SPECIMEN_ORGANIZATION_ID (SPECIMEN_ID), 
        add constraint SPECIMEN_ORGANIZATION_ID 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN (id);

    alter table StorageSpace_Organization 
        add index STORAGESPACE_ORGANIZATION_ID (STORAGESPACE_ID), 
        add constraint STORAGESPACE_ORGANIZATION_ID 
        foreign key (STORAGESPACE_ID) 
        references STORAGESPACE (id);

    alter table StorageSpace_Organization 
        add index ORGANIZATION_STORAGESPACE_ID (ORGANIZATION_ID), 
        add constraint ORGANIZATION_STORAGESPACE_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION (id);

    alter table TELEPHONENUMBER 
        add index TELEPHTYPE_FK (TYPE_FK), 
        add constraint TELEPHTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table TELEPHONENUMBER 
        add index TELEPHCONTAC_FK (CONTACTINFORMATION_FK), 
        add constraint TELEPHCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION (id);

    alter table TISSUESPECIMEN 
        add index FK_TISSUESPECIMEN_BIOSPECIME (ID), 
        add constraint FK_TISSUESPECIMEN_BIOSPECIME 
        foreign key (ID) 
        references BIOSPECIMEN (ID);

    alter table UNIFORMRESOURCEIDENTIFIER 
        add index UNIFORELECTR_FK (ELECTRONICDOCUMENT_FK), 
        add constraint UNIFORELECTR_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT (ID);

    alter table UNIT 
        add index UNITCOTYPE_FK (TYPE_FK), 
        add constraint UNITCOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table WHOLEORGANISM 
        add index FK_WHOLEORGANISM_BIOSPECIMEN (ID), 
        add constraint FK_WHOLEORGANISM_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN (ID);

    alter table WORD 
        add index WORDCONAMING_FK (NAMINGCONVENTION_FK), 
        add constraint WORDCONAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION (id);

    alter table WORKFLOWEVENT 
        add index WORKFLTYPE_FK (TYPE_FK), 
        add constraint WORKFLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE (id);

    alter table WORKFLOWEVENT 
        add index WORKFLOWEVE_LOCATION_FK (LOCATION_FK), 
        add constraint WORKFLOWEVE_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION (id);

    alter table WORKSHEET 
        add index WORKSHBIOCHE_FK (BIOCHEMICALREACTIONMIXTURE_FK), 
        add constraint WORKSHBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE (id);

    alter table WORKSHEET 
        add index WORKSHMETHOD_FK (METHOD_FK), 
        add constraint WORKSHMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD (id);

    alter table WORKSHEET 
        add index WORKSHLABSUP_FK (LABSUPPLY_FK), 
        add constraint WORKSHLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY (id);

    alter table WORKSHEET 
        add index WORKSHEET_SOP_FK (SOP_FK), 
        add constraint WORKSHEET_SOP_FK 
        foreign key (SOP_FK) 
        references SOP (id);

    alter table WORKSHEET 
        add index WORKSHPROCED_FK (PROCEDURE_FK), 
        add constraint WORKSHPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE (id);

    alter table WORKSHEET 
        add index WORKSHPROJECT_FK (PROJECT_FK), 
        add constraint WORKSHPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT (id);
