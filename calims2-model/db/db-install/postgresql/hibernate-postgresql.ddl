
    create table ACCOUNT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp not null,
        STARTDATE timestamp not null,
        STATUS varchar(100) not null,
        LABORATORY_FK int8 not null,
        ORGANIZATION_FK int8 not null,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table ACCOUNTNUMBER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp not null,
        STARTDATE timestamp not null,
        STATUS varchar(100) not null,
        VALUE int8 not null,
        ACCOUNT_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table ADAPTER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK int8,
        FILEFORMATSPECIFICATION_FK int8,
        DOCUMENT_FK int8,
        primary key (id)
    );

    create table ADDITIONALORGANISMNAME (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMMENT varchar(100),
        CONTENT varchar(100),
        DATEASSIGNED timestamp,
        ISCURRENTNAME bool,
        SOURCE varchar(100),
        TYPE_FK int8,
        WHOLEORGANISM_FK int8,
        primary key (id)
    );

    create table ANTIBODY (
        COUNTOFREQUESTS int4,
        ISOTYPE varchar(100),
        RECOMMENDEDDILUTIONRANGE varchar(100),
        ID int8 not null,
        ANTIGEN_FK int8,
        primary key (ID)
    );

    create table ANTIGEN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COUNTOFREQUESTS int8,
        USE varchar(100),
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table APPROVAL (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        BILLINGINFORMATION_FK int8,
        CUSTOMERREQUEST_FK int8,
        EXPERIMENTALRESULT_FK int8,
        FINDING_FK int8,
        INVOICE_FK int8,
        LABSUPPLY_FK int8,
        QUOTATION_FK int8,
        TYPE_FK int8,
        RUN_FK int8,
        PROJECT_FK int8,
        PROCEDURE_FK int8,
        METHOD_FK int8,
        BIOCHEMICALREACTIONMIXTURE_FK int8,
        primary key (id)
    );

    create table APPROVALPOLL (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS int4,
        APPROVAL_FK int8,
        DIGITALSIGNATURE_FK int8,
        PERSON_FK int8,
        primary key (id)
    );

    create table ARTIFICIALSPECIMEN (
        ID int8 not null,
        primary key (ID)
    );

    create table BASEUNIT (
        ID int8 not null,
        primary key (ID)
    );

    create table BILLINGINFORMATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATE timestamp,
        STATUS varchar(100) not null,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table BIOCHEMICALREACTIONMIXTURE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table BIOHAZARD (
        ID int8 not null,
        primary key (ID)
    );

    create table BIOSPECIMEN (
        ID int8 not null,
        TAXON_FK int8,
        TYPE_FK int8,
        primary key (ID)
    );

    create table CARBOHYDRATE (
        CHEMICALFORMULA varchar(100),
        ORIENTATION varchar(100),
        POLYSACCHARIDEREPEATPATTERN varchar(100),
        POLYSACCHARIDEUNIT varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table CELLSPECIMEN (
        CELLCULTUREGROWTHMEDIUM varchar(100),
        CELLCULTUREGROWTHMEDIUMSUPPLE varchar(100),
        COUNTOFREQUESTS int4,
        MYCOPLASMASTATUS varchar(100),
        PASSAGENUMBER int4,
        TARGETEDMUTATION varchar(100),
        ID int8 not null,
        CONTAINER_FK int8,
        primary key (ID)
    );

    create table CHEMICALCOMPOUND (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        NDCCODE varchar(100),
        CHEMICALFORMULA varchar(100),
        EXPIRATIONDATE timestamp,
        CONTAINER_FK int8,
        NANOMATERIAL_FK int8,
        primary key (id)
    );

    create table CLAUSE (
        DTYPE varchar(31) not null,
        id int8 not null,
        CLAUSEINDEX int4,
        OPERATOR varchar(100),
        PROPERTYNAME varchar(100),
        PROPERTYTYPE varchar(100),
        VALUE varchar(100),
        QUERY_FK int8,
        CLAUSE_FK int8,
        DISJUNCTION_FK int8,
        CONJUNCTION_FK int8,
        primary key (id)
    );

    create table COLLABORATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        ROLE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table CONSENSUSAPPROVAL (
        REQUIREDPOLLCOUNT int8,
        REQUIREDREVIEWERCOUNT int8,
        STATUS int4,
        ID int8 not null,
        primary key (ID)
    );

    create table CONTACTINFORMATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        EMAILADDRESS varchar(100),
        RANK int4 not null,
        STATUS varchar(100) not null,
        COLLABORATION_FK int8,
        LABORATORY_FK int8,
        LOCATION_FK int8,
        ORGANIZATION_FK int8,
        PERSON_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table CONTAINER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X int4,
        Y int4,
        ISREUSABLE bool,
        ISTEMPLATE bool,
        STATUS varchar(100),
        CONTAINERTYPE_FK int8,
        FILLPATTERN_FK int8,
        LAYOUT_FK int8,
        LOCATION_FK int8,
        CONTAINER_FK int8,
        primary key (id)
    );

    create table CONTAINERSUBCATEGORY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK int8,
        primary key (id)
    );

    create table CONTAINERTYPE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPOSITION varchar(100),
        CONTAINERTYPE_FK int8,
        CONTAINERSUBCATEGORY_FK int8,
        LAYOUT_FK int8,
        primary key (id)
    );

    create table CONTRACT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table COORDINATE_FILLPATTERN (
        ID_COORDINATE_FILLPATTERN int8 not null,
        X int4,
        Y int4,
        LIST_INDEX int4 not null,
        primary key (ID_COORDINATE_FILLPATTERN, LIST_INDEX)
    );

    create table CUSTOMERREQUEST (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPLETEDDATE timestamp,
        EXPIRATIONDATE timestamp,
        LABORATORYFINALAPPROVEDATE timestamp,
        STATUS varchar(100) not null,
        SUBMISSIONDATE timestamp,
        BILLINGINFORMATION_FK int8,
        ACCOUNT_FK int8,
        PERSON_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table Characteristics (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISQUANTITATIVE bool,
        VALUE varchar(100),
        QUANTITY_VALUE varchar(100),
        DATE timestamp,
        AFFECTEDPERSON varchar(100),
        GENOTYPESEX varchar(100),
        PHENOTYPESEX varchar(100),
        PERSON_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        ANTIGEN_FK int8,
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        COATCOLOR_FK int8,
        CHEMICALCOMPOUND_FK int8,
        SEQUENCE_FK int8,
        NUCLEICACID_FK int8,
        primary key (id)
    );

    create table Collaboration_Laboratory (
        COLLABORATION_ID int8 not null,
        LABORATORY_ID int8 not null,
        primary key (COLLABORATION_ID, LABORATORY_ID)
    );

    create table Collaboration_Person (
        COLLABORATION_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (COLLABORATION_ID, PERSON_ID)
    );

    create table ContainerType_Layout (
        LAYOUT_ID int8 not null,
        CONTAINERTYPE_ID int8 not null,
        primary key (CONTAINERTYPE_ID, LAYOUT_ID)
    );

    create table DATA (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table DIGITALSIGNATURE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        SIGNATURE varchar(100),
        APPROVALPOLL_FK int8,
        DOCUMENT_FK int8,
        PERSON_FK int8,
        primary key (id)
    );

    create table DOCUMENT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
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
        ACCOUNT_FK int8,
        BIOCHEMICALREACTIONMIXTURE_FK int8,
        CHARACTERISTICS_FK int8,
        CHEMICALCOMPOUND_FK int8,
        COLLABORATION_FK int8,
        CONTRACT_FK int8,
        CUSTOMERREQUEST_FK int8,
        DATA_FK int8,
        DIGITALSIGNATURE_FK int8,
        EQUIPMENT_FK int8,
        EVENT_FK int8,
        FILEFORMATSPECIFICATION_FK int8,
        HAZARD_FK int8,
        INVOICE_FK int8,
        LABSUPPLY_FK int8,
        LOCATION_FK int8,
        NAMINGCONVENTION_FK int8,
        ORGANIZATION_FK int8,
        PERSON_FK int8,
        PROCEDURE_FK int8,
        PROJECT_FK int8,
        QUOTATION_FK int8,
        SERVICE_FK int8,
        SPECIMEN_FK int8,
        UNIT_FK int8,
        WORKSHEET_FK int8,
        primary key (id)
    );

    create table ELECTRONICDOCUMENT (
        DIGITALOBJECTIDENTIFIER varchar(100),
        ID int8 not null,
        FILEFORMATSPECIFICATION_FK int8,
        STORAGESPACE_FK int8,
        EQUIPMENT_FK int8,
        primary key (ID)
    );

    create table EQUIPMENT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MODEL varchar(100),
        PROPERTYID varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        LABORATORY_FK int8 not null,
        LOCATION_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table EXPERIMENT (
        STARTDATE timestamp,
        STOPDATE timestamp,
        TITLE varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table EXPERIMENTALRESULT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table EXTERNALIDENTIFIER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOURCE varchar(100),
        STATUS varchar(100),
        VALUE varchar(100),
        ACCOUNT_FK int8,
        CUSTOMERREQUEST_FK int8,
        LABSUPPLY_FK int8,
        PERSON_FK int8,
        SEQUENCE_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table EnvironmentalCondition (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAXIMUMHUMIDITY varchar(100),
        MEASUREDHUMIDITY varchar(100),
        MINIMUMHUMIDITY varchar(100),
        MAXIMUMTEMPERATURE float4,
        MEASUREDTEMPERATURE float4,
        MINIMUMTEMPERATURE float4,
        MAXIMUMPH int8,
        MEASUREDPH int8,
        MINIMUMPH int8,
        MAXIMUMPERCENTCO2 float4,
        MEASUREDPERCENTCO2 float4,
        MINIMUMPERCENTCO2 float4,
        MAXIMUMPERCENTO2 float4,
        MEASUREDPERCENTO2 float4,
        MINIMUMPERCENTO2 float4,
        EVENT_FK int8,
        TYPE_FK int8,
        BIOCHEMICALREACTIONMIXTURE_FK int8,
        primary key (id)
    );

    create table Equipment_Hazard (
        EQUIPMENT_ID int8 not null,
        HAZARD_ID int8 not null,
        primary key (EQUIPMENT_ID, HAZARD_ID)
    );

    create table Equipment_Organization (
        EQUIPMENT_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (EQUIPMENT_ID, ORGANIZATION_ID)
    );

    create table Equipment_Person (
        EQUIPMENT_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (EQUIPMENT_ID, PERSON_ID)
    );

    create table Event (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(100),
        DISPLAYNAME varchar(100),
        NAME varchar(100),
        CONTAINER_FK int8,
        LABSUPPLY_FK int8,
        LOCATION_FK int8,
        PERSON_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        WHOLEORGANISM_FK int8,
        ORGANIZATION_FK int8,
        BIOCHEMICALREACTIONMIXTURE_FK int8,
        primary key (id)
    );

    create table FEATURE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SEQUENCEEND int8,
        SEQUENCESTART int8,
        SITE varchar(100),
        ANTIGEN_FK int8,
        TYPE_FK int8,
        SPECIMEN_FK int8,
        FEATURECOLLECTION_FK int8,
        primary key (id)
    );

    create table FILEEXTENSION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VALUE varchar(100),
        ELECTRONICDOCUMENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table FILEFORMATSPECIFICATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK int8,
        FILEEXTENSION_FK int8,
        FILETRANSPORTER_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table FILETRANSPORTER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        primary key (id)
    );

    create table FILLEDREPORT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXECUTEDBY varchar(100),
        EXECUTIONTIME timestamp,
        DOCUMENT_FK int8,
        REPORT_FK int8,
        primary key (id)
    );

    create table FILLPATTERN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        PERSON_FK int8,
        LAYOUT_FK int8,
        primary key (id)
    );

    create table FINDING (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table FLUIDSPECIMEN (
        PREPARATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table HAZARD (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTAINER_FK int8,
        LABSUPPLY_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table INVOICE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        INVOICEDATE timestamp,
        INVOICEPAYMENTDATE timestamp,
        STATUS varchar(100) not null,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table Invoice_CustomerRequest (
        INVOICE_ID int8 not null,
        CUSTOMERREQUEST_ID int8 not null,
        primary key (INVOICE_ID, CUSTOMERREQUEST_ID)
    );

    create table LABORATORY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        LOCATION_FK int8,
        primary key (id)
    );

    create table LABORATORYOPERATION (
        ID int8 not null,
        primary key (ID)
    );

    create table LABSUPPLY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE timestamp,
        STATUS varchar(100),
        CONTAINER_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table LAYOUT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X_DIMENSION int4,
        X_DIMENSIONLABEL varchar(100) not null,
        Y_DIMENSION int4,
        Y_DIMENSIONLABEL varchar(100) not null,
        PERSON_FK int8,
        primary key (id)
    );

    create table LIPID (
        CATEGORY varchar(100),
        CHEMICALFORMULA varchar(100),
        DELTAXNOMENCLATURE varchar(100),
        FUNCTION varchar(100),
        NXNOMENCLATURE varchar(100),
        SATURATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table LOCATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        VALUE varchar(100),
        LOCATION_FK int8,
        TYPE_FK int8 not null,
        TRAVELHISTORY_FK int8,
        primary key (id)
    );

    create table LabSupply_Organization (
        LABSUPPLY_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (LABSUPPLY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Organization (
        LABORATORY_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (LABORATORY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Person (
        LABORATORY_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (LABORATORY_ID, PERSON_ID)
    );

    create table METHOD (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISTEMPLATE bool,
        ORDEROFEXECUTION int8,
        STATUS int4,
        TYPE_FK int8,
        PROJECT_FK int8,
        primary key (id)
    );

    create table MOLECULARSPECIMEN (
        ID int8 not null,
        primary key (ID)
    );

    create table NAMINGCONVENTION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXAMPLE varchar(100),
        GROUPING varchar(100),
        ISMANDATORY bool,
        ISSUGGESTED bool,
        ISUNIQUE bool,
        MAXIMUMLENGTH int8,
        STATUS varchar(100) not null,
        TYPE int4 not null,
        PERSON_FK int8,
        LABORATORY_FK int8,
        primary key (id)
    );

    create table NANOMATERIAL (
        ID int8 not null,
        CHEMICALCOMPOUND_FK int8,
        primary key (ID)
    );

    create table NOTES_ACCOUNT (
        ID_NOTES_ACCOUNT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_ACCOUNTNUMBER (
        ID_NOTES_ACCOUNTNUMBER int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_ADAPTER (
        ID_NOTES_ADAPTER int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_ADDITIONALORGANISMN (
        ID_NOTES_ADDITIONALORGANI int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_APPROVAL (
        ID_NOTES_APPROVAL int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_APPROVALPOLL (
        ID_NOTES_APPROVALPOLL int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_BILLINGINFORMATION (
        ID_NOTES_BILLINGINFORMATI int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_BIOCHEMICALREACTION (
        ID_NOTES_BIOCHEMICALREACT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_CHARACTERISTICS (
        ID_NOTES_CHARACTERISTICS int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_CONTACTINFORMATION (
        ID_NOTES_CONTACTINFORMATI int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_CUSTOMERREQUEST (
        ID_NOTES_CUSTOMERREQUEST int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_DATA (
        ID_NOTES_DATA int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_DIGITALSIGNATURE (
        ID_NOTES_DIGITALSIGNATURE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_EVENT (
        ID_NOTES_EVENT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_EXPERIMENTALRESULT (
        ID_NOTES_EXPERIMENTALRESU int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_FINDING (
        ID_NOTES_FINDING int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_HAZARD (
        ID_NOTES_HAZARD int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_INVOICE (
        ID_NOTES_INVOICE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_LABSUPPLY (
        ID_NOTES_LABSUPPLY int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_LAYOUT (
        ID_NOTES_LAYOUT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_METHOD (
        ID_NOTES_METHOD int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_PARAMETER (
        ID_NOTES_PARAMETER int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_POSTALADDRESS (
        ID_NOTES_POSTALADDRESS int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_PROCEDURE (
        ID_NOTES_PROCEDURE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_PROJECT (
        ID_NOTES_PROJECT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_QUOTATION (
        ID_NOTES_QUOTATION int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_RATE (
        ID_NOTES_RATE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_ROLE (
        ID_NOTES_ROLE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_RUN (
        ID_NOTES_RUN int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SAFETYCAUTION (
        ID_NOTES_SAFETYCAUTION int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SERVICE (
        ID_NOTES_SERVICE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SERVICEITEM (
        ID_NOTES_SERVICEITEM int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SOFTWARE (
        ID_NOTES_SOFTWARE int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SOP (
        ID_NOTES_SOP int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_SPECIMEN (
        ID_NOTES_SPECIMEN int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_STRAIN (
        ID_NOTES_STRAIN int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_TAXON (
        ID_NOTES_TAXON int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NOTES_WORKFLOWEVENT (
        ID_NOTES_WORKFLOWEVENT int8 not null,
        CONTENT varchar(100),
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        STATUS varchar(100)
    );

    create table NUCLEICACID (
        ID int8 not null,
        primary key (ID)
    );

    create table ORGANIZATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DUNSNUMBER varchar(100),
        IDENTIFIERNUMBER varchar(100),
        ISTAXEXEMPT bool,
        LEGALCATEGORYTYPE varchar(100),
        STATUS varchar(100) not null,
        TAXIDENTIFIERNUMBER varchar(100),
        LOCATION_FK int8,
        ORGANIZATION_FK int8,
        TYPE_FK int8 not null,
        COLLABORATION_FK int8,
        primary key (id)
    );

    create table PARAMETER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        SPECIMEN_FK int8,
        TYPE_FK int8,
        PROCEDURE_FK int8,
        METHOD_FK int8,
        SOFTWARE_FK int8,
        primary key (id)
    );

    create table PCRPRODUCT (
        EXPECTEDSIZE int8,
        OBSERVEDSIZE int8,
        ID int8 not null,
        FORWARDPRIMER_FK int8,
        REVERSEPRIMER_FK int8,
        primary key (ID)
    );

    create table PERSON (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
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
        EXTERNALIDENTIFIER_FK int8,
        PERSONBILLINGINFORMATION_FK int8,
        SERVICEITEMBILLINGINFORMATION_FK int8,
        LABSUPPLY_FK int8,
        primary key (id)
    );

    create table POSTALADDRESS (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
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
        CONTACTINFORMATION_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table PRIMARYDATA (
        ID int8 not null,
        primary key (ID)
    );

    create table PRIMER (
        ID int8 not null,
        primary key (ID)
    );

    create table PROCEDURE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISTEMPLATE bool,
        ORDEROFEXECUTION int8,
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table PROCESSEDDATA (
        ID int8 not null,
        EXPERIMENTALRESULT_FK int8,
        PRIMARYDATA_FK int8,
        primary key (ID)
    );

    create table PROJECT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ACTUALENDDATE timestamp,
        ACTUALSTARTDATE timestamp,
        EXPECTEDENDDATE timestamp,
        EXPECTEDSTARTDATE timestamp,
        ISTEMPLATE bool,
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table PROTEIN (
        CLASSGROUP varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table PROTOCOL (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS int4,
        VERSION varchar(100),
        primary key (id)
    );

    create table Person_Organization (
        PERSON_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (PERSON_ID, ORGANIZATION_ID)
    );

    create table ProcessedData_Finding (
        PROCESSEDDATA_ID int8 not null,
        FINDING_ID int8 not null,
        primary key (FINDING_ID, PROCESSEDDATA_ID)
    );

    create table QUANTITY_BIOCHEMICALREACT (
        ID_QUANTITY_BIOCHEMICALRE int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_CENTRIFUGATIONEV (
        ID_QUANTITY_CENTRIFUGATIO int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_CONTAINER (
        ID_QUANTITY_CONTAINER int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_ENVIRONMENTALCON (
        ID_QUANTITY_ENVIRONMENTAL int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_LABSUPPLY (
        ID_QUANTITY_LABSUPPLY int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_SPECIMEN (
        ID_QUANTITY_SPECIMEN int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUERY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAINENTITY varchar(100),
        TYPE_FK int8,
        primary key (id)
    );

    create table QUOTATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        APPROVALDATE timestamp,
        EXPIRATIONDATE timestamp,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        RATE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table RATE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        PERSON_FK int8,
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table REPORT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        QUERY_FK int8,
        REPORTDESIGN_FK int8,
        primary key (id)
    );

    create table REPORTDESIGN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAINENTITY varchar(100),
        DOCUMENT_FK int8,
        primary key (id)
    );

    create table REVIEWAPPROVAL (
        STATUS int4,
        ID int8 not null,
        primary key (ID)
    );

    create table ROLE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        TYPE int4 not null,
        PERSON_FK int8,
        ORGANIZATION_FK int8,
        LABORATORY_FK int8,
        primary key (id)
    );

    create table RUN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ORDEROFEXECUTION int8,
        STATUS int4,
        TYPE_FK int8,
        primary key (id)
    );

    create table SAFETYCAUTION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HAZARD_FK int8,
        primary key (id)
    );

    create table SEQUENCE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        ASCIIREPRESENTATION varchar(100),
        PARENTENDOFFSET int8,
        PARENTSTARTOFFSET int8,
        STRAND varchar(100),
        ANTIBODY_FK int8,
        ANTIGEN_FK int8,
        CTERMINUS_FK int8,
        PHYSICALCHARACTERISTICS_FK int8,
        NTERMINUS_FK int8,
        NUCLEICACID_FK int8,
        PROTEIN_FK int8,
        primary key (id)
    );

    create table SEQUENTIALAPPROVAL (
        STATUS int4,
        ID int8 not null,
        primary key (ID)
    );

    create table SERVICE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp,
        ISTEMPLATE bool,
        STARTDATE timestamp,
        STATUS varchar(100),
        CUSTOMERREQUEST_FK int8,
        ORGANIZATION_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table SERVICEITEM (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp,
        QUANTITY_VALUE varchar(100),
        SPECIMENTYPE varchar(100),
        STARTDATE timestamp,
        STATUS varchar(100),
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        SERVICE_FK int8,
        RATE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table SIMPLEAPPROVAL (
        STATUS int4,
        ID int8 not null,
        primary key (ID)
    );

    create table SMALLMOLECULE (
        CHEMICALFORMULA varchar(100),
        MECHANISMOFACTION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table SOFTWARE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE timestamp,
        NUMBEROFUSERS int4,
        OPERATINGSYSTEM varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        VERSION varchar(100),
        TYPE_FK int8 not null,
        EQUIPMENT_FK int8,
        primary key (id)
    );

    create table SOP (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        VERSION varchar(100),
        PERSON_FK int8,
        DOCUMENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SPECIMEN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ACTIVITYSTATUS varchar(100),
        CONDITION varchar(100),
        ISAVAILABLE bool,
        RECEIVEDDATETIME timestamp,
        USE varchar(100),
        PERSON_FK int8,
        CONTAINER_FK int8,
        SPECIMEN_FK int8,
        SERVICEITEM_FK int8,
        primary key (id)
    );

    create table STANDARDUNIT (
        CONVERSIONFACTOR numeric(19, 2),
        DATASOURCE varchar(100),
        DATATARGET varchar(100),
        OFFSETVALUE numeric(19, 2),
        ID int8 not null,
        BASEUNIT_FK int8,
        primary key (ID)
    );

    create table STORAGEDEVICE (
        ID int8 not null,
        primary key (ID)
    );

    create table STORAGESPACE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        PERSON_FK int8 not null,
        LOCATION_FK int8 not null,
        LAYOUT_FK int8,
        TYPE_FK int8 not null,
        STORAGEDEVICE_FK int8,
        primary key (id)
    );

    create table STRAIN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ETHNICITY varchar(100),
        ISOLATE varchar(100),
        LINE varchar(100),
        STRAINSUBGROUP varchar(100),
        TAXON_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SUMMARY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HEADERLABELLIST varchar(100),
        MAXIMUMCOLUMNCOUNT int8,
        MAXIMUMROWCOUNT int8,
        QUERY_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SafetyCaution_Document (
        SAFETYCAUTION_ID int8 not null,
        DOCUMENT_ID int8 not null,
        primary key (SAFETYCAUTION_ID, DOCUMENT_ID)
    );

    create table SafetyCaution_Person (
        SAFETYCAUTION_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (SAFETYCAUTION_ID, PERSON_ID)
    );

    create table ServiceItem_AccountNumber (
        SERVICEITEM_ID int8 not null,
        ACCOUNTNUMBER_ID int8 not null,
        primary key (SERVICEITEM_ID, ACCOUNTNUMBER_ID)
    );

    create table Specimen_Location (
        SPECIMEN_ID int8 not null,
        LOCATION_ID int8 not null,
        primary key (SPECIMEN_ID, LOCATION_ID)
    );

    create table Specimen_Organization (
        SPECIMEN_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (SPECIMEN_ID, ORGANIZATION_ID)
    );

    create table StorageSpace_Organization (
        STORAGESPACE_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (STORAGESPACE_ID, ORGANIZATION_ID)
    );

    create table TAXON (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
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
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        RANK varchar(100),
        STATUS varchar(100) not null,
        TELEPHONENUMBEREXTENSION varchar(100),
        VALUE varchar(100),
        CONTACTINFORMATION_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table TISSUESPECIMEN (
        PREPARATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table TYPE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATAELEMENTCOLLECTION varchar(100),
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table UNIFORMRESOURCEIDENTIFIER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TEXT varchar(100),
        VERSION varchar(100),
        ELECTRONICDOCUMENT_FK int8,
        primary key (id)
    );

    create table UNIT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK int8,
        primary key (id)
    );

    create table WHOLEORGANISM (
        COMMONNAME varchar(100),
        ETHNICITYSTRAIN varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table WORD (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CHARACTERSET int4 not null,
        DELIMITER varchar(100),
        ISINCREMENTED bool,
        MAXIMUMLENGTH int4 not null,
        MINIMUMLENGTH int4 not null,
        PADCHARACTER varchar(100),
        RANK int4 not null,
        STATUS varchar(100) not null,
        NAMINGCONVENTION_FK int8,
        primary key (id)
    );

    create table WORKFLOWEVENT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        STATUS int4,
        LOCATION_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table WORKSHEET (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(500),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOP_FK int8,
        LABSUPPLY_FK int8,
        PROJECT_FK int8,
        PROCEDURE_FK int8,
        METHOD_FK int8,
        BIOCHEMICALREACTIONMIXTURE_FK int8,
        primary key (id)
    );

    alter table ACCOUNT 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ACCOUNT 
        add constraint ACCOUNLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table ACCOUNT 
        add constraint ACCOUNORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table ACCOUNTNUMBER 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ACCOUNTNUMBER 
        add constraint ACCOUNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table ADAPTER 
        add constraint ADAPTER_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table ADAPTER 
        add constraint ADAPTER_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table ADAPTER 
        add constraint ADAPTER_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table ADDITIONALORGANISMNAME 
        add constraint ADDITITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ADDITIONALORGANISMNAME 
        add constraint ADDITIWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM;

    alter table ANTIBODY 
        add constraint FK_ANTIBODY_PROTEIN 
        foreign key (ID) 
        references PROTEIN;

    alter table ANTIBODY 
        add constraint ANTIBODY_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    create index ANTIGENUSE_USE_IDX on ANTIGEN (USE);

    alter table ANTIGEN 
        add constraint ANTIGETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ANTIGEN 
        add constraint ANTIGEN_SPECIMEN_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table APPROVAL 
        add constraint APPROVTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table APPROVAL 
        add constraint APPROVINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE;

    alter table APPROVAL 
        add constraint APPROVBILLIN_FK 
        foreign key (BILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table APPROVAL 
        add constraint APPROVRUN_FK 
        foreign key (RUN_FK) 
        references RUN;

    alter table APPROVAL 
        add constraint APPROVPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT;

    alter table APPROVAL 
        add constraint APPROVPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE;

    alter table APPROVAL 
        add constraint APPROVFINDING_FK 
        foreign key (FINDING_FK) 
        references FINDING;

    alter table APPROVAL 
        add constraint APPROVBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table APPROVAL 
        add constraint APPROVMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD;

    alter table APPROVAL 
        add constraint APPROVQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION;

    alter table APPROVAL 
        add constraint APPROVLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table APPROVAL 
        add constraint APPROVEXPERI_FK 
        foreign key (EXPERIMENTALRESULT_FK) 
        references EXPERIMENTALRESULT;

    alter table APPROVAL 
        add constraint APPROVCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table APPROVALPOLL 
        add constraint APPROVALPOLL_DIGITALSIGN_FK 
        foreign key (DIGITALSIGNATURE_FK) 
        references DIGITALSIGNATURE;

    alter table APPROVALPOLL 
        add constraint APPROVAPPROV_FK 
        foreign key (APPROVAL_FK) 
        references APPROVAL;

    alter table APPROVALPOLL 
        add constraint APPROVALPOLL_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table ARTIFICIALSPECIMEN 
        add constraint FK_ARTIFICIALSPECIMEN_SPECIM 
        foreign key (ID) 
        references SPECIMEN;

    alter table BASEUNIT 
        add constraint FK_BASEUNIT_UNIT 
        foreign key (ID) 
        references UNIT;

    alter table BILLINGINFORMATION 
        add constraint BILLINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table BIOCHEMICALREACTIONMIXTURE 
        add constraint BIOCHEMICAL_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table BIOHAZARD 
        add constraint FK_BIOHAZARD_HAZARD 
        foreign key (ID) 
        references HAZARD;

    alter table BIOSPECIMEN 
        add constraint BIOSPETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table BIOSPECIMEN 
        add constraint FK_BIOSPECIMEN_SPECIMEN 
        foreign key (ID) 
        references SPECIMEN;

    alter table BIOSPECIMEN 
        add constraint BIOSPETAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON;

    alter table CARBOHYDRATE 
        add constraint FK_CARBOHYDRATE_MOLECULARSPE 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table CELLSPECIMEN 
        add constraint FK_CELLSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table CELLSPECIMEN 
        add constraint CELLSPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CHEMICALCOMPOUND 
        add constraint CHEMCIALCOM_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CHEMICALCOMPOUND 
        add constraint CHEMICALCOM_NANOMATERIAL_FK 
        foreign key (NANOMATERIAL_FK) 
        references NANOMATERIAL;

    alter table CLAUSE 
        add constraint CLAUSEDISJUN_FK 
        foreign key (DISJUNCTION_FK) 
        references CLAUSE;

    alter table CLAUSE 
        add constraint CLAUSEQUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY;

    alter table CLAUSE 
        add constraint NEGATION_CLAUSE_FK 
        foreign key (CLAUSE_FK) 
        references CLAUSE;

    alter table CLAUSE 
        add constraint CLAUSECONJUN_FK 
        foreign key (CONJUNCTION_FK) 
        references CLAUSE;

    alter table COLLABORATION 
        add constraint COLLABTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table COLLABORATION 
        add constraint COLLABROLE_FK 
        foreign key (ROLE_FK) 
        references ROLE;

    alter table CONSENSUSAPPROVAL 
        add constraint FK_CONSENSUSAPPROVAL_APPROVA 
        foreign key (ID) 
        references APPROVAL;

    alter table CONTACTINFORMATION 
        add constraint CONTACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CONTACTINFORMATION 
        add constraint CONTACLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table CONTACTINFORMATION 
        add constraint CONTACCOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table CONTACTINFORMATION 
        add constraint CONTACPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table CONTACTINFORMATION 
        add constraint CONTACLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table CONTACTINFORMATION 
        add constraint CONTACORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table CONTAINER 
        add constraint CONTAILOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table CONTAINER 
        add constraint CONTAIFILLPA_FK 
        foreign key (FILLPATTERN_FK) 
        references FILLPATTERN;

    alter table CONTAINER 
        add constraint CONTAILAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table CONTAINER 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE;

    alter table CONTAINER 
        add constraint CHILDCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CONTAINERSUBCATEGORY 
        add constraint CONTAITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CONTAINERTYPE 
        add constraint RELATELAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table CONTAINERTYPE 
        add constraint _CONTAINERTY_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE;

    alter table CONTAINERTYPE 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERSUBCATEGORY_FK) 
        references CONTAINERSUBCATEGORY;

    alter table COORDINATE_FILLPATTERN 
        add constraint FK_COORDINATE_FILLPATTERN 
        foreign key (ID_COORDINATE_FILLPATTERN) 
        references FILLPATTERN;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMBILLIN_FK 
        foreign key (BILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMERREQ_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table Characteristics 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table Characteristics 
        add constraint CHARACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table Characteristics 
        add constraint BODYRECOATCO_FK 
        foreign key (COATCOLOR_FK) 
        references Characteristics;

    alter table Characteristics 
        add constraint PHYSICNUCLEI_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID;

    alter table Characteristics 
        add constraint CHEMICSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE;

    alter table Characteristics 
        add constraint CHARACSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table Characteristics 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table Characteristics 
        add constraint BIOCHAANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table Characteristics 
        add constraint FAMILYHISTO_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table Characteristics 
        add constraint PHYSICCHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table Collaboration_Laboratory 
        add constraint LABORATORY_COLLABORATIO_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Collaboration_Laboratory 
        add constraint COLLABORATIO_LABORATORY_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION;

    alter table Collaboration_Person 
        add constraint PERSON_COLLABORATIO_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table Collaboration_Person 
        add constraint COLLABORATIO_PERSON_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION;

    alter table ContainerType_Layout 
        add constraint CONTAINERTYP_LAYOUT_ID 
        foreign key (CONTAINERTYPE_ID) 
        references CONTAINERTYPE;

    alter table ContainerType_Layout 
        add constraint LAYOUT_CONTAINERTYP_ID 
        foreign key (LAYOUT_ID) 
        references LAYOUT;

    alter table DATA 
        add constraint DATATYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table DIGITALSIGNATURE 
        add constraint DIGITALSIGN_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table DIGITALSIGNATURE 
        add constraint DIGITALSIGN_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table DIGITALSIGNATURE 
        add constraint DIGITALSIGN_APPROVALPOLL_FK 
        foreign key (APPROVALPOLL_FK) 
        references APPROVALPOLL;

    alter table DOCUMENT 
        add constraint IMAGEFILE_DIGITALSIGN_FK 
        foreign key (DIGITALSIGNATURE_FK) 
        references DIGITALSIGNATURE;

    alter table DOCUMENT 
        add constraint DOCUMENAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION;

    alter table DOCUMENT 
        add constraint DOCUMEEVENT_FK 
        foreign key (EVENT_FK) 
        references Event;

    alter table DOCUMENT 
        add constraint REFERENCE_CHARACTERIS_FK 
        foreign key (CHARACTERISTICS_FK) 
        references Characteristics;

    alter table DOCUMENT 
        add constraint REFRENCE_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD;

    alter table DOCUMENT 
        add constraint DOCUMEPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT;

    alter table DOCUMENT 
        add constraint DOCUMESERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE;

    alter table DOCUMENT 
        add constraint DOCUMEQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION;

    alter table DOCUMENT 
        add constraint DOCUMELABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table DOCUMENT 
        add constraint DOCUMECHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table DOCUMENT 
        add constraint DOCUMECUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table DOCUMENT 
        add constraint DOCUMELOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table DOCUMENT 
        add constraint DOCUMESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table DOCUMENT 
        add constraint DOCUMEINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE;

    alter table DOCUMENT 
        add constraint DOCUMECOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table DOCUMENT 
        add constraint DOCUMEWORKSH_FK 
        foreign key (WORKSHEET_FK) 
        references WORKSHEET;

    alter table DOCUMENT 
        add constraint DOCUMEPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table DOCUMENT 
        add constraint DOCUMEORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table DOCUMENT 
        add constraint DOCUMENT_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table DOCUMENT 
        add constraint DOCUMEPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE;

    alter table DOCUMENT 
        add constraint DOCUMEBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table DOCUMENT 
        add constraint DOCUMEEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table DOCUMENT 
        add constraint DOCUMECONTRA_FK 
        foreign key (CONTRACT_FK) 
        references CONTRACT;

    alter table DOCUMENT 
        add constraint DOCUMEACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table DOCUMENT 
        add constraint DOCUMEDATA_FK 
        foreign key (DATA_FK) 
        references DATA;

    alter table DOCUMENT 
        add constraint REFERENCE_UNIT_FK 
        foreign key (UNIT_FK) 
        references UNIT;

    alter table ELECTRONICDOCUMENT 
        add constraint MANUALEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table ELECTRONICDOCUMENT 
        add constraint FK_ELECTRONICDOCUMENT_DOCUME 
        foreign key (ID) 
        references DOCUMENT;

    alter table ELECTRONICDOCUMENT 
        add constraint MANUALSTORAG_FK 
        foreign key (STORAGESPACE_FK) 
        references STORAGESPACE;

    alter table ELECTRONICDOCUMENT 
        add constraint FILE_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table EQUIPMENT 
        add constraint EQUIPMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EQUIPMENT 
        add constraint EQUIPMENT_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table EQUIPMENT 
        add constraint EQUIPMLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table EXPERIMENT 
        add constraint FK_EXPERIMENT_METHOD 
        foreign key (ID) 
        references METHOD;

    alter table EXPERIMENTALRESULT 
        add constraint EXPERIMENTA_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNALIDE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table EnvironmentalCondition 
        add constraint ENVIROTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EnvironmentalCondition 
        add constraint ENVIROBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table EnvironmentalCondition 
        add constraint ENVIROEVENT_FK 
        foreign key (EVENT_FK) 
        references Event;

    alter table Equipment_Hazard 
        add constraint EQUIPMENT_HAZARD_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Hazard 
        add constraint HAZARD_EQUIPMENT_ID 
        foreign key (HAZARD_ID) 
        references HAZARD;

    alter table Equipment_Organization 
        add constraint ORGANIZATION_EQUIPMENT_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Equipment_Organization 
        add constraint EQUIPMENT_ORGANIZATION_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Person 
        add constraint EQUIPMENT_PERSON_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Person 
        add constraint PERSON_EQUIPMENT_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table Event 
        add constraint EVENTCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table Event 
        add constraint EVENTCBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table Event 
        add constraint EVENTCLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table Event 
        add constraint EVENTCSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table Event 
        add constraint EVENTCWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM;

    alter table Event 
        add constraint EVENTCPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table Event 
        add constraint EVENTCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table Event 
        add constraint EVENTCLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table Event 
        add constraint EVENTCORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table FEATURE 
        add constraint FEATURTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FEATURE 
        add constraint FEATURSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table FEATURE 
        add constraint EPITOPANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table FEATURE 
        add constraint FEATURSEQUEN_FK 
        foreign key (FEATURECOLLECTION_FK) 
        references SEQUENCE;

    alter table FILEEXTENSION 
        add constraint FILEEXTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FILEEXTENSION 
        add constraint FILEEXTENSI_ELECTRONICD_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFOFILETR_FK 
        foreign key (FILETRANSPORTER_FK) 
        references FILETRANSPORTER;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFORMATS_FILEEXTENSI_FK 
        foreign key (FILEEXTENSION_FK) 
        references FILEEXTENSION;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFORMATS_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table FILLEDREPORT 
        add constraint FILLEDREPORT_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table FILLEDREPORT 
        add constraint FILLEDREPORT_FK 
        foreign key (REPORT_FK) 
        references REPORT;

    alter table FILLPATTERN 
        add constraint FILLPALAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table FILLPATTERN 
        add constraint FILLPATTERN_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table FINDING 
        add constraint FINDING_TYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FLUIDSPECIMEN 
        add constraint FK_FLUIDSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table HAZARD 
        add constraint HAZARDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table HAZARD 
        add constraint HAZARDSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table HAZARD 
        add constraint HAZARD_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table HAZARD 
        add constraint HAZARDLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table INVOICE 
        add constraint INVOICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table Invoice_CustomerRequest 
        add constraint INVOICE_CUSTOMERREQU_ID 
        foreign key (INVOICE_ID) 
        references INVOICE;

    alter table Invoice_CustomerRequest 
        add constraint CUSTOMERREQU_INVOICE_ID 
        foreign key (CUSTOMERREQUEST_ID) 
        references CUSTOMERREQUEST;

    alter table LABORATORY 
        add constraint LABORATORY_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table LABORATORYOPERATION 
        add constraint FK_LABORATORYOPERATION_METHO 
        foreign key (ID) 
        references METHOD;

    alter table LABSUPPLY 
        add constraint LABSUPTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table LABSUPPLY 
        add constraint LABSUPCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table LAYOUT 
        add constraint LAYOUT_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table LIPID 
        add constraint FK_LIPID_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table LOCATION 
        add constraint LOCATITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table LOCATION 
        add constraint CHILDLLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table LOCATION 
        add constraint LOCATITRAVEL_FK 
        foreign key (TRAVELHISTORY_FK) 
        references Characteristics;

    alter table LabSupply_Organization 
        add constraint ORGANIZATION_LABSUPPLY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table LabSupply_Organization 
        add constraint LABSUPPLY_ORGANIZATION_ID 
        foreign key (LABSUPPLY_ID) 
        references LABSUPPLY;

    alter table Laboratory_Organization 
        add constraint ORGANIZATION_LABORATORY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Laboratory_Organization 
        add constraint LABORATORY_ORGANIZATION_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Laboratory_Person 
        add constraint LABORATORY_PERSON_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Laboratory_Person 
        add constraint PERSON_LABORATORY_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table METHOD 
        add constraint METHODTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table METHOD 
        add constraint METHODPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT;

    alter table MOLECULARSPECIMEN 
        add constraint FK_MOLECULARSPECIMEN_BIOSPEC 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table NAMINGCONVENTION 
        add constraint NAMINGCONVE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table NAMINGCONVENTION 
        add constraint NAMINGLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table NANOMATERIAL 
        add constraint FK_NANOMATERIAL_ARTIFICIALSP 
        foreign key (ID) 
        references ARTIFICIALSPECIMEN;

    alter table NANOMATERIAL 
        add constraint NANOMATERIAL_CHEMICALCOM_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table NOTES_ACCOUNT 
        add constraint FK_NOTES_ACCOUNT 
        foreign key (ID_NOTES_ACCOUNT) 
        references ACCOUNT;

    alter table NOTES_ACCOUNTNUMBER 
        add constraint FK_NOTES_ACCOUNTNUMBER 
        foreign key (ID_NOTES_ACCOUNTNUMBER) 
        references ACCOUNTNUMBER;

    alter table NOTES_ADAPTER 
        add constraint FK_NOTES_ADAPTER 
        foreign key (ID_NOTES_ADAPTER) 
        references ADAPTER;

    alter table NOTES_ADDITIONALORGANISMN 
        add constraint FK_NOTES_ADDITIONALORGANI 
        foreign key (ID_NOTES_ADDITIONALORGANI) 
        references ADDITIONALORGANISMNAME;

    alter table NOTES_APPROVAL 
        add constraint FK_NOTES_APPROVAL 
        foreign key (ID_NOTES_APPROVAL) 
        references APPROVAL;

    alter table NOTES_APPROVALPOLL 
        add constraint FK_NOTES_APPROVALPOLL 
        foreign key (ID_NOTES_APPROVALPOLL) 
        references APPROVALPOLL;

    alter table NOTES_BILLINGINFORMATION 
        add constraint FK_NOTES_BILLINGINFORMATI 
        foreign key (ID_NOTES_BILLINGINFORMATI) 
        references BILLINGINFORMATION;

    alter table NOTES_BIOCHEMICALREACTION 
        add constraint FK_NOTES_BIOCHEMICALREACT 
        foreign key (ID_NOTES_BIOCHEMICALREACT) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table NOTES_CHARACTERISTICS 
        add constraint FK_NOTES_CHARACTERISTICS 
        foreign key (ID_NOTES_CHARACTERISTICS) 
        references Characteristics;

    alter table NOTES_CONTACTINFORMATION 
        add constraint FK_NOTES_CONTACTINFORMATI 
        foreign key (ID_NOTES_CONTACTINFORMATI) 
        references CONTACTINFORMATION;

    alter table NOTES_CUSTOMERREQUEST 
        add constraint FK_NOTES_CUSTOMERREQUEST 
        foreign key (ID_NOTES_CUSTOMERREQUEST) 
        references CUSTOMERREQUEST;

    alter table NOTES_DATA 
        add constraint FK_NOTES_DATA 
        foreign key (ID_NOTES_DATA) 
        references DATA;

    alter table NOTES_DIGITALSIGNATURE 
        add constraint FK_NOTES_DIGITALSIGNATURE 
        foreign key (ID_NOTES_DIGITALSIGNATURE) 
        references DIGITALSIGNATURE;

    alter table NOTES_EVENT 
        add constraint FK_NOTES_EVENT 
        foreign key (ID_NOTES_EVENT) 
        references Event;

    alter table NOTES_EXPERIMENTALRESULT 
        add constraint FK_NOTES_EXPERIMENTALRESU 
        foreign key (ID_NOTES_EXPERIMENTALRESU) 
        references EXPERIMENTALRESULT;

    alter table NOTES_FINDING 
        add constraint FK_NOTES_FINDING 
        foreign key (ID_NOTES_FINDING) 
        references FINDING;

    alter table NOTES_HAZARD 
        add constraint FK_NOTES_HAZARD 
        foreign key (ID_NOTES_HAZARD) 
        references HAZARD;

    alter table NOTES_INVOICE 
        add constraint FK_NOTES_INVOICE 
        foreign key (ID_NOTES_INVOICE) 
        references INVOICE;

    alter table NOTES_LABSUPPLY 
        add constraint FK_NOTES_LABSUPPLY 
        foreign key (ID_NOTES_LABSUPPLY) 
        references LABSUPPLY;

    alter table NOTES_LAYOUT 
        add constraint FK_NOTES_LAYOUT 
        foreign key (ID_NOTES_LAYOUT) 
        references LAYOUT;

    alter table NOTES_METHOD 
        add constraint FK_NOTES_METHOD 
        foreign key (ID_NOTES_METHOD) 
        references METHOD;

    alter table NOTES_PARAMETER 
        add constraint FK_NOTES_PARAMETER 
        foreign key (ID_NOTES_PARAMETER) 
        references PARAMETER;

    alter table NOTES_POSTALADDRESS 
        add constraint FK_NOTES_POSTALADDRESS 
        foreign key (ID_NOTES_POSTALADDRESS) 
        references POSTALADDRESS;

    alter table NOTES_PROCEDURE 
        add constraint FK_NOTES_PROCEDURE 
        foreign key (ID_NOTES_PROCEDURE) 
        references PROCEDURE;

    alter table NOTES_PROJECT 
        add constraint FK_NOTES_PROJECT 
        foreign key (ID_NOTES_PROJECT) 
        references PROJECT;

    alter table NOTES_QUOTATION 
        add constraint FK_NOTES_QUOTATION 
        foreign key (ID_NOTES_QUOTATION) 
        references QUOTATION;

    alter table NOTES_RATE 
        add constraint FK_NOTES_RATE 
        foreign key (ID_NOTES_RATE) 
        references RATE;

    alter table NOTES_ROLE 
        add constraint FK_NOTES_ROLE 
        foreign key (ID_NOTES_ROLE) 
        references ROLE;

    alter table NOTES_RUN 
        add constraint FK_NOTES_RUN 
        foreign key (ID_NOTES_RUN) 
        references RUN;

    alter table NOTES_SAFETYCAUTION 
        add constraint FK_NOTES_SAFETYCAUTION 
        foreign key (ID_NOTES_SAFETYCAUTION) 
        references SAFETYCAUTION;

    alter table NOTES_SERVICE 
        add constraint FK_NOTES_SERVICE 
        foreign key (ID_NOTES_SERVICE) 
        references SERVICE;

    alter table NOTES_SERVICEITEM 
        add constraint FK_NOTES_SERVICEITEM 
        foreign key (ID_NOTES_SERVICEITEM) 
        references SERVICEITEM;

    alter table NOTES_SOFTWARE 
        add constraint FK_NOTES_SOFTWARE 
        foreign key (ID_NOTES_SOFTWARE) 
        references SOFTWARE;

    alter table NOTES_SOP 
        add constraint FK_NOTES_SOP 
        foreign key (ID_NOTES_SOP) 
        references SOP;

    alter table NOTES_SPECIMEN 
        add constraint FK_NOTES_SPECIMEN 
        foreign key (ID_NOTES_SPECIMEN) 
        references SPECIMEN;

    alter table NOTES_STRAIN 
        add constraint FK_NOTES_STRAIN 
        foreign key (ID_NOTES_STRAIN) 
        references STRAIN;

    alter table NOTES_TAXON 
        add constraint FK_NOTES_TAXON 
        foreign key (ID_NOTES_TAXON) 
        references TAXON;

    alter table NOTES_WORKFLOWEVENT 
        add constraint FK_NOTES_WORKFLOWEVENT 
        foreign key (ID_NOTES_WORKFLOWEVENT) 
        references WORKFLOWEVENT;

    alter table NUCLEICACID 
        add constraint FK_NUCLEICACID_MOLECULARSPEC 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table ORGANIZATION 
        add constraint ORGANITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ORGANIZATION 
        add constraint ORGANIZATION_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table ORGANIZATION 
        add constraint ORGANICOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table ORGANIZATION 
        add constraint CHILDOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table PARAMETER 
        add constraint PARAMETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table PARAMETER 
        add constraint PARAMESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table PARAMETER 
        add constraint PARAMEMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD;

    alter table PARAMETER 
        add constraint PARAMESOFTWA_FK 
        foreign key (SOFTWARE_FK) 
        references SOFTWARE;

    alter table PARAMETER 
        add constraint PARAMEPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE;

    alter table PCRPRODUCT 
        add constraint FK_PCRPRODUCT_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID;

    alter table PCRPRODUCT 
        add constraint PCRPRODUCTB_PRIMER_FK 
        foreign key (FORWARDPRIMER_FK) 
        references PRIMER;

    alter table PCRPRODUCT 
        add constraint PCRPRODUCTA_PRIMER_FK 
        foreign key (REVERSEPRIMER_FK) 
        references PRIMER;

    alter table PERSON 
        add constraint PERSON_EXTERNALIDE_FK 
        foreign key (EXTERNALIDENTIFIER_FK) 
        references EXTERNALIDENTIFIER;

    alter table PERSON 
        add constraint SERVICBILLIN_FK 
        foreign key (SERVICEITEMBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table PERSON 
        add constraint PERSONLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table PERSON 
        add constraint PERSONBILLIN_FK 
        foreign key (PERSONBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table POSTALADDRESS 
        add constraint POSTALTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table POSTALADDRESS 
        add constraint POSTALCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION;

    alter table PRIMARYDATA 
        add constraint FK_PRIMARYDATA_DATA 
        foreign key (ID) 
        references DATA;

    alter table PRIMER 
        add constraint FK_PRIMER_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID;

    alter table PROCEDURE 
        add constraint PROCEDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table PROCESSEDDATA 
        add constraint PROCESPRIMAR_FK 
        foreign key (PRIMARYDATA_FK) 
        references PRIMARYDATA;

    alter table PROCESSEDDATA 
        add constraint FK_PROCESSEDDATA_DATA 
        foreign key (ID) 
        references DATA;

    alter table PROCESSEDDATA 
        add constraint PROCESEXPERI_FK 
        foreign key (EXPERIMENTALRESULT_FK) 
        references EXPERIMENTALRESULT;

    alter table PROJECT 
        add constraint PROCEDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table PROTEIN 
        add constraint FK_PROTEIN_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table Person_Organization 
        add constraint ORGANIZATION_PERSON_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Person_Organization 
        add constraint PERSON_ORGANIZATION_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table ProcessedData_Finding 
        add constraint PROCESSEDDAT_FINDING_ID 
        foreign key (PROCESSEDDATA_ID) 
        references PROCESSEDDATA;

    alter table ProcessedData_Finding 
        add constraint FINDING_PROCESSEDDAT_ID 
        foreign key (FINDING_ID) 
        references FINDING;

    alter table QUANTITY_BIOCHEMICALREACT 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_BIOCHEMICALREACT 
        add constraint FK_QUANTITY_BIOCHEMICALRE 
        foreign key (ID_QUANTITY_BIOCHEMICALRE) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table QUANTITY_BIOCHEMICALREACT 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint FK_QUANTITY_CENTRIFUGATIO 
        foreign key (ID_QUANTITY_CENTRIFUGATIO) 
        references Event;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_CONTAINER 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_CONTAINER 
        add constraint FK_QUANTITY_CONTAINER 
        foreign key (ID_QUANTITY_CONTAINER) 
        references CONTAINER;

    alter table QUANTITY_CONTAINER 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint FK_QUANTITY_ENVIRONMENTAL 
        foreign key (ID_QUANTITY_ENVIRONMENTAL) 
        references EnvironmentalCondition;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_LABSUPPLY 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_LABSUPPLY 
        add constraint FK_QUANTITY_LABSUPPLY 
        foreign key (ID_QUANTITY_LABSUPPLY) 
        references LABSUPPLY;

    alter table QUANTITY_LABSUPPLY 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_SPECIMEN 
        add constraint FK_QUANTITY_SPECIMEN 
        foreign key (ID_QUANTITY_SPECIMEN) 
        references SPECIMEN;

    alter table QUANTITY_SPECIMEN 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_SPECIMEN 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUERY 
        add constraint QUERYCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUOTATION 
        add constraint QUOTATTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUOTATION 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table QUOTATION 
        add constraint QUOTATION_RATE_FK 
        foreign key (RATE_FK) 
        references RATE;

    alter table QUOTATION 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table RATE 
        add constraint RATECOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table RATE 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table RATE 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table RATE 
        add constraint RATE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table REPORT 
        add constraint REPORTQUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY;

    alter table REPORT 
        add constraint REPORTREPORT_FK 
        foreign key (REPORTDESIGN_FK) 
        references REPORTDESIGN;

    alter table REPORTDESIGN 
        add constraint REPORTDESIGN_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table REVIEWAPPROVAL 
        add constraint FK_REVIEWAPPROVAL_APPROVAL 
        foreign key (ID) 
        references APPROVAL;

    alter table ROLE 
        add constraint ROLECOPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table ROLE 
        add constraint ROLECOLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table ROLE 
        add constraint ROLECOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table RUN 
        add constraint RUNCOLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SAFETYCAUTION 
        add constraint SAFETYCAUTI_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD;

    alter table SEQUENCE 
        add constraint SEQUENCE_NUCLEICACID_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID;

    alter table SEQUENCE 
        add constraint SEQUENCEA_FEATURE_FK 
        foreign key (NTERMINUS_FK) 
        references FEATURE;

    alter table SEQUENCE 
        add constraint SEQUENCE_PHYSICALCHA_FK 
        foreign key (PHYSICALCHARACTERISTICS_FK) 
        references Characteristics;

    alter table SEQUENCE 
        add constraint SEQUENCE_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table SEQUENCE 
        add constraint SEQUENCEB_FEATURE_FK 
        foreign key (CTERMINUS_FK) 
        references FEATURE;

    alter table SEQUENCE 
        add constraint ANTIBODYBIN_ANTIBODY_FK 
        foreign key (ANTIBODY_FK) 
        references ANTIBODY;

    alter table SEQUENCE 
        add constraint SEQUENPROTEIN_FK 
        foreign key (PROTEIN_FK) 
        references PROTEIN;

    alter table SEQUENTIALAPPROVAL 
        add constraint FK_SEQUENTIALAPPROVAL_APPROV 
        foreign key (ID) 
        references APPROVAL;

    alter table SERVICE 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SERVICE 
        add constraint SERVICORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table SERVICE 
        add constraint SERVICCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table SERVICEITEM 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SERVICEITEM 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table SERVICEITEM 
        add constraint SERVICEITEM_RATE_FK 
        foreign key (RATE_FK) 
        references RATE;

    alter table SERVICEITEM 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table SERVICEITEM 
        add constraint SERVICSERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE;

    alter table SIMPLEAPPROVAL 
        add constraint FK_SIMPLEAPPROVAL_APPROVAL 
        foreign key (ID) 
        references APPROVAL;

    alter table SMALLMOLECULE 
        add constraint FK_SMALLMOLECULE_MOLECULARSP 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table SOFTWARE 
        add constraint SOFTWATYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SOFTWARE 
        add constraint SOFTWAEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table SOP 
        add constraint SOPCOLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SOP 
        add constraint SOP_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table SOP 
        add constraint SOP_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table SPECIMEN 
        add constraint CHILDSSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table SPECIMEN 
        add constraint SPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table SPECIMEN 
        add constraint SPECIMPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table SPECIMEN 
        add constraint SPECIMSERVIC_FK 
        foreign key (SERVICEITEM_FK) 
        references SERVICEITEM;

    alter table STANDARDUNIT 
        add constraint FK_STANDARDUNIT_UNIT 
        foreign key (ID) 
        references UNIT;

    alter table STANDARDUNIT 
        add constraint STANDABASEUN_FK 
        foreign key (BASEUNIT_FK) 
        references BASEUNIT;

    alter table STORAGEDEVICE 
        add constraint FK_STORAGEDEVICE_EQUIPMENT 
        foreign key (ID) 
        references EQUIPMENT;

    alter table STORAGESPACE 
        add constraint STORAGTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table STORAGESPACE 
        add constraint STORAGLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table STORAGESPACE 
        add constraint STORAGSTORAG_FK 
        foreign key (STORAGEDEVICE_FK) 
        references STORAGEDEVICE;

    alter table STORAGESPACE 
        add constraint STORAGESPACE_LAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table STORAGESPACE 
        add constraint STORAGESPACE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table STRAIN 
        add constraint STRAINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table STRAIN 
        add constraint ORGANISMSTR_TAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON;

    alter table SUMMARY 
        add constraint SUMMARTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SUMMARY 
        add constraint SUMMARY_QUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY;

    alter table SafetyCaution_Document 
        add constraint DOCUMENT_SAFETYCAUTIO_ID 
        foreign key (DOCUMENT_ID) 
        references DOCUMENT;

    alter table SafetyCaution_Document 
        add constraint SAFETYCAUTIO_DOCUMENT_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION;

    alter table SafetyCaution_Person 
        add constraint PERSON_SAFETYCAUTIO_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table SafetyCaution_Person 
        add constraint SAFETYCAUTIO_PERSON_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION;

    alter table ServiceItem_AccountNumber 
        add constraint SERVICEITEM_ACCOUNTNUMBE_ID 
        foreign key (SERVICEITEM_ID) 
        references SERVICEITEM;

    alter table ServiceItem_AccountNumber 
        add constraint ACCOUNTNUMBE_SERVICEITEM_ID 
        foreign key (ACCOUNTNUMBER_ID) 
        references ACCOUNTNUMBER;

    alter table Specimen_Location 
        add constraint SPECIMEN_LOCATION_ID 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table Specimen_Location 
        add constraint LOCATION_SPECIMEN_ID 
        foreign key (LOCATION_ID) 
        references LOCATION;

    alter table Specimen_Organization 
        add constraint ORGANIZATION_SPECIMEN_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Specimen_Organization 
        add constraint SPECIMEN_ORGANIZATION_ID 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table StorageSpace_Organization 
        add constraint STORAGESPACE_ORGANIZATION_ID 
        foreign key (STORAGESPACE_ID) 
        references STORAGESPACE;

    alter table StorageSpace_Organization 
        add constraint ORGANIZATION_STORAGESPACE_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table TELEPHONENUMBER 
        add constraint TELEPHTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table TELEPHONENUMBER 
        add constraint TELEPHCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION;

    alter table TISSUESPECIMEN 
        add constraint FK_TISSUESPECIMEN_BIOSPECIME 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table UNIFORMRESOURCEIDENTIFIER 
        add constraint UNIFORELECTR_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT;

    alter table UNIT 
        add constraint UNITCOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table WHOLEORGANISM 
        add constraint FK_WHOLEORGANISM_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table WORD 
        add constraint WORDCONAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION;

    alter table WORKFLOWEVENT 
        add constraint WORKFLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table WORKFLOWEVENT 
        add constraint WORKFLOWEVE_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table WORKSHEET 
        add constraint WORKSHBIOCHE_FK 
        foreign key (BIOCHEMICALREACTIONMIXTURE_FK) 
        references BIOCHEMICALREACTIONMIXTURE;

    alter table WORKSHEET 
        add constraint WORKSHMETHOD_FK 
        foreign key (METHOD_FK) 
        references METHOD;

    alter table WORKSHEET 
        add constraint WORKSHLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table WORKSHEET 
        add constraint WORKSHEET_SOP_FK 
        foreign key (SOP_FK) 
        references SOP;

    alter table WORKSHEET 
        add constraint WORKSHPROCED_FK 
        foreign key (PROCEDURE_FK) 
        references PROCEDURE;

    alter table WORKSHEET 
        add constraint WORKSHPROJECT_FK 
        foreign key (PROJECT_FK) 
        references PROJECT;

    create sequence hibernate_sequence;

    create sequence specimen_sequence start with 1;

    CREATE FUNCTION create_task_users() RETURNS trigger AS ' BEGIN INSERT INTO task_organizationalentity (dtype,id) VALUES (''User'',new.login_name); RETURN new; END; ' LANGUAGE plpgsql;

    CREATE TRIGGER create_task_users AFTER INSERT ON csm_user FOR EACH ROW EXECUTE PROCEDURE create_task_users();

    CREATE FUNCTION update_task_users() RETURNS trigger AS ' BEGIN UPDATE task_organizationalentity SET id = new.login_name WHERE dtype = ''User'' and id = old.login_name; RETURN new; END; ' LANGUAGE plpgsql;

    CREATE TRIGGER update_task_users AFTER UPDATE ON csm_user FOR EACH ROW EXECUTE PROCEDURE update_task_users();

    CREATE FUNCTION delete_task_users() RETURNS trigger AS ' BEGIN DELETE FROM task_organizationalentity WHERE dtype = ''User'' and id = old.login_name; RETURN old; END; ' LANGUAGE plpgsql;

    CREATE TRIGGER delete_task_users AFTER DELETE ON csm_user FOR EACH ROW EXECUTE PROCEDURE delete_task_users();
