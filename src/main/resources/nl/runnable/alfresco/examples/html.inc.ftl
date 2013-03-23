<#-- Macro that generates a Bootstrap document. -->
<#macro document title="">
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${url.context}/css/dynamic-extensions/bootstrap/css/bootstrap.min.css"/>
    <title>${title}</title>
  </head>
  <body>
    <#nested/>
  </body>
</html>
</#macro>
