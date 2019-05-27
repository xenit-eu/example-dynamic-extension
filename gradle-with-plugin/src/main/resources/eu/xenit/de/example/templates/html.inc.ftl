<#-- Macro that generates a Bootstrap document. -->
<#macro document title="">
<!DOCTYPE html>
<html>
  <head>
    <style type="text/css">
      <#include "../stylesheets/bootstrap.min.css" />
    </style>
    <title>${title}</title>
  </head>
  <body>
    <#nested/>
  </body>
</html>
</#macro>
