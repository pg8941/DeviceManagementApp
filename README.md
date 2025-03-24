# DeviceManagementApp
**Device Management Application Report**

**1. Introduction:**

This project aims to develop a backend system for monitoring and managing USB devices. It provides real-time status tracking, basic usage analytics, and configuration options through REST APIs. The goal is to create a foundational system that can be expanded to address various device management needs.

**2. Why Needed:**

Improved Device Visibility: In environments with numerous USB devices, tracking their status and usage can be challenging. This application provides a centralized view.
Enhanced Security: Monitoring for unauthorized device connections is crucial for data security. The application can flag suspicious activity.
Streamlined Diagnostics: Quick identification of device issues reduces downtime and improves efficiency.
Automation Potential: The API-driven approach allows for automation of device management tasks.

**3. What It Does:**

The application provides the following core functionalities:

Retrieves a list of connected devices.
Retrieves the status of a specific device.
Updates the status of a device.
Optionally, filters devices by type.
**4. Tech Stack:**

Java: The primary programming language.
Spring Boot: A framework for rapid application development.
REST APIs: For communication between clients and the backend.
Code Snippet (DeviceController.java):

Java

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/api/devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("/api/devices/{id}/status")
    public void updateDeviceStatus(@PathVariable String id, @RequestBody Map<String, String> payload) {
        String status = payload.get("status");
        if (status != null) {
            deviceService.updateDeviceStatus(id, status);
        }
    }
}
**5. Results:**

Successfully created a functional REST API for device management.
Implemented basic device status tracking and updating.
Demonstrated the feasibility of a centralized device management system.
Testing Results:
All API endpoints responded as expected.
Device status updates were correctly reflected.
Basic error handling was implemented.
**6. Tools and Technologies:**

Spring Tool Suite (STS): IDE for development.
Git Bash: Version control.
Postman: API testing.
Java 17.
Maven.
**7. Challenges:**

Simulating hardware interaction without direct device access.
Designing a scalable architecture.
Implementing robust error handling.
Platform dependent hardware access.
**8. Future Scope:**

Database Integration: To persist device data.
Hardware Interaction: Implement code for real USB device detection and monitoring.
Advanced Analytics: Add usage analytics and reporting features.
Security Enhancements: Implement authentication and authorization.
User Interface: Develop a web or mobile interface.
Enhanced Diagnostics: Implement detailed device diagnostics.
Android Integration: Use android SDK to manage android devices.
**9. What's New From Present:**

Centralized device management through REST APIs.
Basic real-time status tracking.
A foundation for future enhancements.
**10. Input and Output:**

Input:
HTTP requests (GET, PUT) to the API.
Device status updates via JSON payloads.
Output:
JSON responses containing device information.
Device status updates.
**11. Usecases:**

Corporate IT: Managing USB devices in a network.
Industrial Automation: Monitoring sensors and actuators.
Smart Homes: Controlling IoT devices.
Data Centers: Monitoring server hardware.


Testing and Validation: This application can be used to test and validate the functionality of the  USB framework with various USB devices.
Debugging and Diagnostics: The application's monitoring capabilities can help identify and troubleshoot issues related to USB device communication and compatibility.
Security Analysis: The application can be extended to analyze the security implications of USB device connections, helping to identify potential vulnerabilities.
Framework Improvement: The development of this application provides valuable insights into the strengths and weaknesses of the USB framework, leading to potential improvements.
**13. User Point of View:**

Simplified Device Management: Users can easily monitor and control their connected devices.
Improved Security: Users are alerted to unauthorized device connections.
Enhanced Troubleshooting: Users can quickly identify and resolve device issues.
**14. Diagram and Structure:**

+-----------------+     REST API     +---------------------+     Data     +------------------+
| DeviceController| <-------------> | DeviceService       | <---------> | In-Memory/Database |
+-----------------+                 +---------------------+              +------------------+
        ^                                   ^
        |                                   |
        |                                   |
+---------------+                        +----------+
| HTTP Clients  |                        | Device   |
+---------------+                        | Model    |
                                         +----------+
**15. Result Part and Testing Results:**

All API endpoints were tested using Postman.
The application successfully retrieves and updates device information.
Testing confirmed the application's ability to track and manage device status.
Testing confirmed the ability to filter devices by type.
Future testing should include more robust error handling, and security testing.

******************************************************************************************************************************************************************************************************************

**Postman Testing Results**

**Environment:**

Application URL: http://localhost:8080
Postman Version: (Specify your Postman version if possible)
Test Cases:

GET /api/devices (Get All Devices)

Method: GET
URL: http://localhost:8080/api/devices
Headers: Content-Type: application/json (optional, but good practice)
Body: None
**Expected Result:**
HTTP Status Code: 200 OK

Response Body: A JSON array of Device objects, each containing id, name, status, and type.

**Example Response:**

JSON

[
    {
        "id": "1",
        "name": "USB Drive",
        "status": "Online",
        "type": "Storage"
    },
    {
        "id": "2",
        "name": "Printer",
        "status": "Offline",
        "type": "Peripheral"
    },
    {
        "id": "3",
        "name": "Webcam",
        "status": "Online",
        "type": "Input"
    }
]
**Actual Result:** (Document the actual response you received. If it matches the expected result, state "Pass"; if not, describe the differences.)
Status Code: 200 OK
Response body: matched expected result.
Result: Pass
GET /api/devices/{id} (Get Device by ID)

Method: GET
URL: http://localhost:8080/api/devices/1 (replace "1" with a valid device ID)
Headers: Content-Type: application/json (optional)
Body: None
Expected Result:
HTTP Status Code: 200 OK

Response Body: A JSON object representing the device with the specified ID.

**Example Response:**

JSON

{
    "id": "1",
    "name": "USB Drive",
    "status": "Online",
    "type": "Storage"
}
Actual Result: (Document the actual response.)
Status Code: 200 OK
Response body: matched expected result.
Result: Pass
PUT /api/devices/{id}/status (Update Device Status)

Method: PUT
URL: http://localhost:8080/api/devices/1/status
Headers: Content-Type: application/json
Body:
Raw JSON:

JSON

{
    "status": "Offline"
}
**Expected Result:**
HTTP Status Code: 200 OK (or 204 No Content, depending on your implementation)
Response Body: (Typically empty for a PUT request)
Actual Result: (Document the actual response and status code.)
Status Code: 200 OK
Response Body: Empty
Result: Pass
Verification: After the PUT request, perform a GET /api/devices/1 request to verify that the device's status has been updated.
GET /api/devices/type/{type} (Get Devices by Type)

Method: GET
URL: http://localhost:8080/api/devices/type/Storage
Headers: Content-Type: application/json
Body: None
Expected Result:
HTTP Status Code: 200 OK

Response Body: A JSON array of Device objects with the specified type.

Example Response:

JSON

[
    {
        "id": "1",
        "name": "USB Drive",
        "status": "Offline",
        "type": "Storage"
    }
]
Actual Result: (Document the actual response.)
Status Code: 200 OK
Response Body: matched expected result.
Result: Pass
GET /api/devices/{invalid_id} (Invalid Device ID)

Method: GET
URL: http://localhost:8080/api/devices/invalid_id
Headers: Content-Type: application/json
Body: None
Expected Result:
HTTP Status Code: 404 Not Found (or a similar error code)
Response Body: An error message indicating that the device was not found.
Actual Result: (Document the actual response.)
Status Code: 404 Not Found
Response Body: (If you added a message, put it here)
Result: Pass
