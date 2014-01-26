<sitemesh:parameter name="menubar.active" value="notifications"/>
<style>
input, textarea{
    display: block;
}
</style>

<h2>Push simple message</h2>

<g:form action="notification" method="post">

    <label for="title">Title</label>
    <input type="text" id="title" name="title" placeholder="Title"/>

    <label for="description">Description</label>
    <textarea name="description" id="description" placeholder="Description"></textarea>

    <button class="btn" >Send</button>

</g:form>