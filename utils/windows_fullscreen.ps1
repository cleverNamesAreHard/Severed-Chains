# Define the window title you are searching for
# This variable stores the title of the window that we want to target.
$windowTitle = "Legend of Dragoon"

# Find the process with the matching window title
# We use Get-Process to retrieve all running processes and filter them by the window title.
$process = Get-Process | Where-Object { 
    $_.MainWindowTitle -like "*$windowTitle*" 
}

# Check if a process was found
# If the process exists (meaning a window with the specified title is found), we proceed.
if ($process) {
    # Get the window handle of the process, assuming there is only one match
    # MainWindowHandle is the unique identifier (handle) for the window associated with the process.
    $hwnd = $process.MainWindowHandle

    # Handle the case where $hwnd is an array
    # Sometimes, $hwnd might be an array if multiple windows match the criteria. We pick the first one.
    if ($hwnd -is [System.Collections.IEnumerable]) {
        $hwnd = $hwnd[0]
    }

    # Convert the window handle to IntPtr directly by casting
    # This ensures that the window handle is in the correct format for use with the Windows API.
    $hwnd = [System.IntPtr]$hwnd

    # Define the P/Invoke signature for ShowWindowAsync
    # This defines the signature for the ShowWindowAsync method from user32.dll, which allows us to change the window state (e.g., maximize).
    $sig = '[DllImport("user32.dll")] public static extern bool ShowWindowAsync(IntPtr hWnd, int nCmdShow);'
    Add-Type -MemberDefinition $sig -Name NativeMethods -Namespace Win32

    # Maximize the window and bring it to the front
    # 3 is the command for maximizing the window using ShowWindowAsync.
    # This will make the window fullscreen without necessarily making it the active window.
    [Win32.NativeMethods]::ShowWindowAsync($hwnd, 3)

    # Check if the User32 type is already added
    # We want to define the necessary methods for modifying the window style only if they haven't been defined yet.
    if (-not ([System.Management.Automation.PSTypeName]'User32').Type) {
        # Define the P/Invoke functions to call user32.dll methods
        # This block defines the User32 class with methods for manipulating window styles and positions.
        Add-Type @"
        using System;
        using System.Runtime.InteropServices;
        
        public class User32 {
            // Import the GetWindowLong method from user32.dll
            // This method retrieves information about the specified window.
            [DllImport("user32.dll", SetLastError = true)]
            public static extern int GetWindowLong(IntPtr hWnd, int nIndex);

            // Import the SetWindowLong method from user32.dll
            // This method changes an attribute of the specified window.
            [DllImport("user32.dll")]
            public static extern int SetWindowLong(IntPtr hWnd, int nIndex, int dwNewLong);

            // Import the SetWindowPos method from user32.dll
            // This method changes the size, position, and Z order of the window.
            [DllImport("user32.dll", SetLastError = true)]
            public static extern bool SetWindowPos(IntPtr hWnd, IntPtr hWndInsertAfter, int X, int Y, int cx, int cy, uint uFlags);

            // Constants representing various window styles and flags.
            public const int GWL_STYLE = -16;           // The window style attribute
            public const int WS_BORDER = 0x00800000;    // The window has a border
            public const int WS_DLGFRAME = 0x00400000;  // The window has a dialog frame (title bar)
            public const int SWP_NOMOVE = 0x0002;       // Retain the current position (don't move)
            public const int SWP_NOSIZE = 0x0001;       // Retain the current size (don't resize)
            public const int SWP_NOZORDER = 0x0004;     // Retain the current Z order (don't re-order)
            public const int SWP_NOACTIVATE = 0x0010;   // Do not activate the window
            public const int SWP_FRAMECHANGED = 0x0020; // Apply changes to the window frame
        }
"@
    }

    # Get current window style
    # Retrieve the current style settings for the window using GetWindowLong.
    $style = [User32]::GetWindowLong($hwnd, [User32]::GWL_STYLE)

    # Remove the title bar (caption bar) and frame
    # We modify the window style to remove the title bar and frame by clearing specific bits in the style.
    $style = $style -band -bnot ([User32]::WS_BORDER -bor [User32]::WS_DLGFRAME)

    # Set the new style
    # Apply the modified style settings to the window using SetWindowLong.
    [User32]::SetWindowLong($hwnd, [User32]::GWL_STYLE, $style)

    # Apply the changes to the window without resizing or moving it
    # SetWindowPos applies the frame changes without altering the window's size or position.
    [User32]::SetWindowPos($hwnd, [IntPtr]::Zero, 0, 0, 0, 0, 
        [User32]::SWP_NOMOVE -bor [User32]::SWP_NOSIZE -bor [User32]::SWP_NOZORDER -bor [User32]::SWP_NOACTIVATE -bor [User32]::SWP_FRAMECHANGED)

    # Provide feedback that the operation was successful
    Write-Host "The window has been maximized, brought to the front, and the title bar has been hidden for the window with title '$windowTitle'."
} else {
    # If no matching process was found, output a message to the user
    Write-Host "No process found with the window title '$windowTitle'."
}
