# Country List App

This is a simple Android app that fetches a list of countries from a JSON API and displays them in a RecyclerView. Each country is shown with its name, region, code, and capital.

## Technologies Used

- Kotlin
- Android SDK
- RecyclerView
- Coroutines
- Retrofit
- Gson
- ViewModel
- LiveData
- Lifecycle
- Error handling
- Device rotation support

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
   git clone https://github.com/your-username/country-list-app.git
