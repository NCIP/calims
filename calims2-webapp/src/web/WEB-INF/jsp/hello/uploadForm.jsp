<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data" commandName="form" action="/calims2-webapp/hello/uploadForm.do">
      <fieldset>
                  <legend>Upload Fields</legend>
                  <p>
                      <form:label for="name" path="name">Name</form:label><br/>
                      <form:input path="name"/>
                  </p>
                  <p>
                      <form:label for="fileData" path="fileData">File</form:label><br/>
                      <form:input path="fileData" type="file"/>
                  </p>
                  <p>
                      <input type="submit" />
                  </p>
        </fieldset>
</form:form>