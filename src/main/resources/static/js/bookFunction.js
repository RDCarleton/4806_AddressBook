$(document).ready(function (){
    function createBook (){
        $.ajax({
            type: "POST",
            url: '/newJSONBook',
            data: {},
            dataType: "json"}).done(function (){
                $(".bookDiv").html("").html(
                    "    <label for=\"name\">Buddy Name:</label><br>\n" +
                    "    <input type=\"text\" id=\"name\" name=\"name\" class=\"name\"><br>\n" +
                    "    <label for=\"address\">Address:</label><br>\n" +
                    "    <input type=\"text\" id=\"address\" name=\"address\" class=\"address\"><br><br>\n" +
                    "    <button type=\"button\" class=\"newBuddyButton\">Add a new Buddy</button>\n"
                   )
            });
        }

    function createBuddy (){
        $.ajax({
            type: "POST",
            url: '/addJSONBuddy',
            data: { "name": $(".name").val(), "address": $(".address").val()},
            dataType: "json"}).done(
            function (){
                $(".bookDiv").html("").html("<table class=\"bookTable\">\n" +
                    "    <thead>\n" +
                    "    <tr>\n" +
                    "        <th>AddressBook ID</th>\n" +
                    "        <th>Buddy</th>\n" +
                    "    </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>\n" +
                    "    <tr th:each=\"book : ${addressBooks}\">\n" +
                    "        <td th:text=\"${book.getID()}\"></td>\n" +
                    "        <td th:text=\"${book.getHTML()}\"></td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n" +
                    "<a href=\"/addMoreBuddies\" class=\"buddyLink\">Add another buddy</a>")
            });
        }


    function addMoreBuddies(){
        $.ajax({
            url: '/result',
        }).done( function () {
            $(".bookDiv").html("").html(
                "    <label for=\"name\">Buddy Name:</label><br>\n" +
                "    <input type=\"text\" id=\"name\" name=\"name\" class=\"name\"><br>\n" +
                "    <label for=\"address\">Address:</label><br>\n" +
                "    <input type=\"text\" id=\"address\" name=\"address\" class=\"address\"><br><br>\n" +
                "    <button type=\"submit\" value=\"Submit\" class=\"newBuddyButton\">Add a new Buddy</button>\n"
            )
            });
        }


    $(".newBookButton").click(function (e){
        e.preventDefault();
        createBook();
    });
    $(".newBuddyButton").onclick =
        createBuddy();
    $(".buddyLink").click(function (e){
        e.preventDefault();
        addMoreBuddies();
    });


});

