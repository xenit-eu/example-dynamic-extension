<#import "templates/html.inc.ftl" as html>
<@html.document title="Hello, ${name}">
  <div class="navbar navbar-inverse navbar-top">
    <div class="navbar-inner">
      <div class="container">
        <a class="brand" href="#">Dynamic Extensions</a>
        <ul class="nav">
        </ul>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="hero-unit">
      <h1>Hello, ${name}</h1>
      <p>
        Example use of a template in an annotation-based Web Script.
      </p>
    </div>
  </div>
</@html.document>
