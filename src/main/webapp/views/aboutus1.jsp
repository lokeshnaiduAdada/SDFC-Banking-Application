<center>
    <fieldset>
        <div style="width: 75%;">
            <img src="sdfc.png" alt="error">
            <h1 style="color: red;">SDFC BANK</h1>
            <h2 style="color: green;">EXTRAORDINARY SERVICES</h2>
            <a href="home">Home</a>&nbsp;&nbsp;
            <a href="account">Account</a>&nbsp;&nbsp;
            <a href="login">Login</a>&nbsp;&nbsp;
            <a href="withdraw">Withdraw</a>&nbsp;&nbsp;
            <a href="deposite">Deposite</a>&nbsp;&nbsp;
            <a href="transfer">Transfer</a>&nbsp;&nbsp;
            <a href="balance">Balance</a>&nbsp;&nbsp;
            <a href="close">Close</a>&nbsp;&nbsp;
            <a href="aboutus">About us</a>&nbsp;&nbsp;
            <div style="display: flex;">
                <div style="width: 30%;">
                    <h1 style="color: red; background-color: pink; margin: 10px; border-radius: 10px;">Service</h1>
                    <h4>Whatsapp</h4>
                    <h4>Door Step Banking</h4>
                    <h4>UPI Autopay</h4>
                    <h4>Mobile Banking</h4>
                </div>
                <div id="div3" style="width: 40%;">
                    <h1 style="color: red; background-color: pink; width: 85%; margin: 10px;border-radius: 10px;">About Us</h1>
                    <section>
                        <img class="mySlides" src="1.jpg" style="width:100%">
                        <img class="mySlides" src="2.jpg" style="width:100%">
                        <img class="mySlides" src="3.jpg" style="width:100%">
                        <img class="mySlides" src="e1.jpg" style="width:100%">
                    </section>
                    <script>
                        var myIndex = 0;
                        carousel();
    
                        function carousel() 
                        {
                            var i;
                            var x = document.getElementsByClassName("mySlides");
                            for (i = 0; i < x.length; i++) 
                            {
                                x[i].style.display = "none";
                            }
                            myIndex++;
                            if (myIndex > x.length) 
                            {
                                myIndex = 1
                            }
                            x[myIndex-1].style.display = "block";
                            setTimeout(carousel, 2000);
                        }
                    </script>
                    <p>
                        SDFC encourages and supports local micro, small and medium sized enterprises and entrepreneurial start-ups to contribute to the local communities. We strongly believe in inclusive economic growth for the well-being of the entire population.
                    </p>
                </div>
                <div style="width: 30%;">
                    <h1 style="color: red; background-color: pink; margin: 10px; border-radius: 10px;">Welcome</h1>
                    <img src="employee.png" alt="error" width="70%">
                    <p>
                        SDFC encourages and supports local micro, small and medium sized enterprises and entrepreneurial start-ups to contribute to the local communities. We strongly believe in inclusive economic growth for the well-being of the entire population.
                    </p>
                </div>
            </div>
        </div>
    </fieldset>
</center>

</body>
</html>