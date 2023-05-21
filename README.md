# Blogging Platform API


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`

## Data Flow

### 1. Model:
* It consists of User, Post ,BlogFollowing ,BlogFollower, BlogComment and AuthenticationToken entity classes along with their data members and member functions
* Used *@Table* and *@Entity* annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like *@Data,* *@NoArgsConstructor*, *@AllArgsConstructor* getters and setters for those object generate automatically.
* Used  @OneToOne, @ManyToOne and OneToMany mapping between 
entities.

### 2. Controller:
* It consists of  userController, PostController, CommentController, classes in which used the annotations like *@RestController* to annotate the class as Controller.
* Used annotation *@GetMapping* , *@PostMapping* , *@PutMapping* , *@DeleteMapping* to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:

<br>

>User API References

* Signup User:
```*.sh-session
  http://13.49.159.144:8080/user/signup
```

* Signin User:
```*.sh-session
  http://13.49.159.144:8080/user/signin
```

* Signout User:
```*.sh-session
  http://13.49.159.144:8080/user/signout?email={email}&token={token}
```

* Following Other User:
```*.sh-session
  http://13.49.159.144:8080/user/follow/myId/{myId}/otherId/{otherId}
```

>Post API References

* Add Post:
```*.sh-session
 http://13.49.159.144:8080/post?email={email}&token={token}
```
* Get All Post:
```*.sh-session
 http://13.49.159.144:8080/post?email={email}&token={token}
```
* Update Post:
```*.sh-session
 http://13.49.159.144:8080/post/?email={email}&token={token}&postId={postId}&postTitle={postTitle}
```
* Delete Post:
```*.sh-session
 http://13.49.159.144:8080/post/?email={email}&token={token}&postId={postId}
```
>Comment API References

* Add Comment:
```*.sh-session
 http://13.49.159.144:8080/comment
```
* Get All Comments:
```*.sh-session
 http://13.49.159.144:8080/comment
```
* Update Comment:
```*.sh-session
 http://13.49.159.144:8080/comment?email={email}&token={token}&commentId={commentId}&commentBody={commentBody}
```
* Delete Comment:
```*.sh-session
 http://13.49.159.144:8080/comment/commentId/{commentId}
```

### 3. Service:
* It consists of UserService, PostService, TokenService,CommentService FollowerService and  FollowingService classes in which provide some business logic of every handler methods.
* Used *@Service* annotation to indicate that a class belongs to the service layer.
* Used *@Transactional* annotation to separate transaction management code from the code for business logic on the update and delete methods.

### 4. Repository:
* It consists of *IUserRepo, *IPostRepo*, *ITokenRepo*, ICommentRepo,IFollowerRepo, IFollowingRepo interface that extends JpaRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used *@Repository* annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used *@Modifying* annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.


## Project Summary

* The aim of these project to create API for Blogging Platform.
* In This project I create API for Post a blog ,Update Post ,delete Post and getAll Posts and also crating api for  comments and follow and following  a post.
* In this project I performed CRUD operation like add,get,delete and update.<br/>
* In this project i am using  one to one, **one-to-many**, and *many-to-one* relationships mapping between entity classes.
* Used interface JpaRepository  for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.
