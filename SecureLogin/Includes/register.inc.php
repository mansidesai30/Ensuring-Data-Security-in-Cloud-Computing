<?php
include_once 'db_connect.php';
include_once 'psl-config.php';
 
$error_msg = "";
 
if (isset($_POST['register'])) {
    // Sanitize and validate the data passed in
    $username = $_POST['username'];
    $email    = $_POST['email'];
    $f_name   = $_POST['f_name'];
    $l_name   = $_POST['l_name'];
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        // Not a valid email
        $error_msg .= '<p class="error">The email address you entered is not valid</p>';
    }
 
    $password = $_POST['password'];

    // Username validity and password validity have been checked client side.
    // This should should be adequate as nobody gains any advantage from
    // breaking these rules.
    //
 
    $prep_stmt = "SELECT id FROM passengers WHERE email = ? LIMIT 1";
    $stmt = $mysqli->prepare($prep_stmt);
    
   // check existing email  
    if ($stmt) {
        $stmt->bind_param('s', $email);
        $stmt->execute();
        $stmt->store_result();
        
        if ($stmt->num_rows == 1) {
            // A user with this email address already exists
            $error_msg .= '<p class="error">A user with this email address already exists.</p>';
                        $stmt->close();
        }
    } /*else {
        $error_msg .= '<p class="error">Database error Line 39</p>';
                //$stmt->close();
    }*/
 
    // check existing username
    $prep_stmt = "SELECT id FROM passengers WHERE username = ? LIMIT 1";
    $stmt = $mysqli->prepare($prep_stmt);
 
    if ($stmt) {
        $stmt->bind_param('s', $username);
        $stmt->execute();
        $stmt->store_result();
 
                if ($stmt->num_rows == 1) {
                        // A user with this username already exists
                        $error_msg .= '<p class="error">A user with this username already exists</p>';
                        $stmt->close();
                }
        } /*else {
                $error_msg .= '<p class="error">Database error line 55</p>';
               // $stmt->close();
        }*/
       
    // TODO: 
    // We'll also have to account for the situation where the user doesn't have
    // rights to do registration, by checking what type of user is attempting to
    // perform the operation.
    
    if (empty($error_msg)) {
         
        // Create hashed password using the password_hash function.
        // This function salts it with a random salt and can be verified with
        // the password_verify function.
        $password =  password_hash($password,PASSWORD_BCRYPT);
       
 
        // Insert the new user into the database 
        if ($insert_stmt = $mysqli->prepare("INSERT INTO passengers (f_name, l_name, username, email, password) VALUES (?, ?, ?, ?, ?)")) {
            $insert_stmt->bind_param('sssss', $f_name, $l_name, $username, $email, $password);
            // Execute the prepared query.
            if (! $insert_stmt->execute()) {
                
                echo "<script>alert('Registration Failure!');</script>";
                echo '<script>window.location="../registration/index.php";</script>';
            }
        }
        
        echo "<script>alert('Registration Successful!');</script>";
        echo '<script>window.location="../registration/index.php";</script>';
    }
}
?>