1. docker pull islamsabirov631/taskservice
2. docker run -p 1239:1239 islamsabirov631/taskservice

3. приложение будет доступно по адресу: http://localhost:1239/



POST http://localhost:1239/auth/register
{
  "username": "string",
  "password": "string"
}
ОТВЕТ
200 OK


POST http://localhost:1239/auth/login 
{
  "username": "string",
  "password": "string"
}
ОТВЕТ
{
  "accessToken": "...",
  "refreshToken": "...."
}



POST http://localhost:1239/auth/refresh
{
  "refreshToken": "...."
}
ОТВЕТ
{
  "accessToken": "..."
}




POST http://localhost:1239/tasks/add
{
  "title": "Task title",
  "description": "Task description",
  "status": "NEW"
}
ОТВЕТ
200 task added


GET http://localhost:1239/tasks/get?taskId=
Authorization: Bearer <токен>
ОТВЕТ
{
  "id": 1,
  "title": "...",
  "description": "...",
  "status": "NEW"
}



GET http://localhost:1239/tasks/getAll
Authorization: Bearer <токен>
ОТВЕТ
[
{
  "id": 1,
  "title": "...",
  "description": "...",
  "status": "NEW"
},
{
  "id": 2,
  "title": "...",
  "description": "...",
  "status": "NEW"
},
...



POST http://localhost:1239/tasks/delete?id=1
Authorization: Bearer <токен>
ОТВЕТ
task deleted


POST http://localhost:1239/tasks/update
Authorization: Bearer <токен>
{
  "id": 1,
  "title": "Updated title",
  "description": "Updated description",
  "status": "IN_PROGRESS"
}
ОТВЕТ
task updated




