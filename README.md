# Conrad 2022

该项目已经进行前后端分离，请前往对应的目录查看使用方式。


# Design doc

## API
### Sign in
1. 登录 [login]（第三方接口）
2. 注册 [register]

### Dashboard
1. 预览 [getList]
2. 添加 [addMap]
3. 查看 [getMap]
4. 上传 [uploadMap]（callback）
5. map改名 [renameMap]

## Database
- user
  - id
  - email
  - password
  - 个人信息
- maps
  - id
  - name
  - originalFile
  - transferedFile
  - ownerId(user.id)
  - timestamp
  - state
- session
  - id
  - cookie

## web 机器学习交互
uploadMap -> call scripts -> python -> call finishApi
