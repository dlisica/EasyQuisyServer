# EasyQuisyServer

API for EasyQuisyApp.<br/>
Java Spring Boot, Maven. MongoDB. <br/>
Automatically deployed to Heroku: http://easy-quisy-api.herokuapp.com.

## <code>GET</code> routes
<code>/quiz</code> fetching all quizzes <br/>
<code>/quiz/id/{quizId}</code> fetching quiz with id=quizId <br/>
<code>/quiz/stat</code> fetching all quiz statistics <br/>
<code>/quiz/stat/id/{quizId}</code> fetching quiz statistics with id=quizId <br/>

<code>/player</code> fetching all players <br/>
<code>/player/id/{playerId}</code> fetching player with id=playerId <br/>
<code>/player/leaderboard</code> fetching all players sorted desc by average score<br/>

## <code>POST</code> routes - data transfer via HTTP Request Body<br/>
<code>/quiz/insert</code> insert quiz <br/>
<code>/player/insert</code> insert player <br/>
<code>/player/login</code> player login <br/>
<code>/player/change-password</code> changing of player's password <br/>
<code>/result</code> insert result of one playing of quiz by one player <br/>
