# Country List App

This is a simple Android app that fetches a list of countries from a JSON API and displays them in a RecyclerView. Each country is shown with its name, region, code, and capital.

 <img src="https://github.com/luizeth0/CountriesApp/assets/123969601/8a249f9c-72be-49f4-bd4d-b329be251ea4" alt="Screenshot 2" width="200px" heigh="600">
 <img src="https://github.com/luizeth0/CountriesApp/assets/123969601/c7f99bd9-b9f6-456c-b305-55bbdd13d654" alt="Screenshot 2" width="600px" heigh="600">


## Technologies Used

- Kotlin: The primary programming language used for Android app development.
- RecyclerView: A UI component for displaying large lists of data efficiently.
- Coroutines: Used for asynchronous programming and handling network requests.
- Retrofit: A popular HTTP client library for making API calls in Android.
- Gson: A library for serializing and deserializing JSON data in Android.
- ViewModel: Part of Android Architecture Components, used for managing UI-related data.
- LiveData: Also part of Android Architecture Components, provides observable data for UI updates.
- Lifecycle: Android Architecture Components library for lifecycle-aware components.
- Error handling: Implemented robust error handling for network requests and edge cases.
- Device rotation support: Implemented support for handling configuration changes during device rotation.

## Project Structure

The project follows a standard Android project structure:

- `app/src/main/java`: Contains the Kotlin code for the app.
- `app/src/main/res`: Contains the XML layout files, strings, and other resources.
- `app/src/main/AndroidManifest.xml`: Defines the app's components, permissions, and configurations.
- `app/src/main/assets`: Can be used for storing additional files, such as fonts or HTML templates.
- `app/src/test`: Contains unit tests for the app's logic.
- `app/build.gradle`: The Gradle build configuration file for the app.

## Implementation Details

### Networking

- The app uses Retrofit library to fetch the list of countries from the provided JSON API URL.
- Coroutines are utilized to handle the asynchronous network requests in a clean and efficient manner.
- Error handling is implemented to handle network failures, server errors, and other exceptions that may occur during the API call.

### RecyclerView and UI

- The fetched country list is displayed using a RecyclerView, which efficiently handles large lists of data.
- Each country item is displayed in a table-like format, showing the country's name, region, code, and capital.
- The UI layout is designed using XML layout files, and the data binding approach can be used for connecting the UI elements with the data.

### Device Rotation

- The app handles device rotation by preserving the state of the RecyclerView and other UI components.
- ViewModel and LiveData are used to retain and update the data across configuration changes.
- The app ensures a seamless user experience when the device is rotated, without losing the fetched data or the current scroll position.

## Getting Started

To build and run the project, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/luizeth0/CountriesApp.git
   
2. Open the project in Android Studio.

3. Build and run the app on an emulator or a physical device.

Future Enhancements
Here are some potential enhancements that can be made to the app:

Implement search functionality to allow users to search for specific countries.
Add pagination support to load countries in batches for better performance.
Improve UI design and styling for a more visually appealing user interface.
Implement caching mechanism to store and load the country list for offline usage.
Add unit tests to ensure the correctness of the implemented functionality.
