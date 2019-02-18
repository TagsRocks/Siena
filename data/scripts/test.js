//This code will always execute first. Sub functions won't be called unless manually invoked.

// Validate our binding.
if (player != null) {
    
    // dummy axe variable.
    var axe = 1351;

    // waits for 2000 milliseconds then invokes 'cut'.
    wait_for(2000, cut)
}

//Example of a sub function.
function cut() {
    // sub functions should always validate values again when invoked via a wait_for.
    if (player == null)
        return;
    
    if (in_area(player, 3200, 3200, 3300, 3300)) {
        chat_message(player, "You can't chop trees in here.");
        return;
    }
    if (axe == 1351) {
        chat_message(player, "Your axe is fine. ");
        do_anim(player, 892);
    } else {
        chat_message(player, "You don't have an axe. ");
    }
}
