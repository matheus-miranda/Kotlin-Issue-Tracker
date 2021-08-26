# JetBrains Issue Tracker

## Intro
This is the final app project for the Inter Android Developer Bootcamp

The app searches all the issues from any <a href="https://github.com/JetBrains">JetBrains</a> repository.

## Features
Consumes data from the <a href="https://docs.github.com/en/rest/reference/issues">Issues Github API.</a>

From the home screen, you can type the name of any JetBrains public repository and you'll receive a list of issue titles and their state (open, closed, or all).
Clicking an item, takes you to a more detailed screen with the possibility to visit the URL in your browser.
<br />
<br />
While building this app, the most recent best practices from Google were adopted with the Jetpack libraries, including:
- <a href="https://developer.android.com/guide/navigation">Safe args Navigation</a>
- <a href="https://developer.android.com/guide/fragments">Fragments</a>
- <a href="https://developer.android.com/topic/libraries/data-binding/">DataBinding</a>
- <a href="https://developer.android.com/topic/libraries/data-binding/binding-adapters">Binding adapters</a>
- <a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a>
- <a href="https://developer.android.com/kotlin/coroutines">Coroutines</a>
- <a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a>
- Custom transition animations

Libraries used:
- <a href="https://square.github.io/retrofit/">Retrofit</a>
- <a href="https://square.github.io/okhttp/4.x/okhttp-logging-interceptor/okhttp3.logging/">OkHttp Logging Interceptor</a>
- <a href="https://insert-koin.io/docs/quickstart/kotlin/">Koin</a>
- <a href="https://bumptech.github.io/glide/">Glide</a>
<br />

## Screens
 <table style="width:100%">
  <tr>
    <th>Home screen</th>
    <th>After searching</th>
    <th>Details screen</th>
    <th>View in browser</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259493-c46e91a6-88c8-4fe0-9f61-8c9d80a92159.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259504-e4b0a945-c2f1-4d80-a9bb-cc6340dfdb1a.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259500-6b94663d-9f0b-4b85-ae58-c9d581ffc87c.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259503-8d1da78c-c2f0-4a72-851c-0f5f15d0092b.jpg"></td>
  </tr>
 </table>
 <br />
 
 <table style="width:100%">
  <tr>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259860-ffdb7b27-2931-4664-a66a-c5d80069c2ba.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259854-30529112-5e8d-4eb1-8648-af161d9e25bd.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259861-66fde132-0855-4782-8e8e-32e83d4a95eb.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/127259862-0fe2264c-7290-432f-a875-e0f7c9750e11.jpg"></td>
  </tr>
 </table>
 <br />
 
 ## In use
<img src="https://user-images.githubusercontent.com/15269393/127260788-5299dc8b-d6a2-4913-b8f4-0b22f5c865ae.gif">
