const cardsArray = [
    'img1', 'img2', 'img3', 'img4',
    'img5', 'img6', 'img7', 'img8',
    'img1', 'img2', 'img3', 'img4',
    'img5', 'img6', 'img7', 'img8'
];
let firstCard = null;
let secondCard = null;
let lockBoard = false;
let matches = 0;
let attempts = 0;
let timer;
let seconds = 0;

document.addEventListener('DOMContentLoaded', () => {
    const gameBoard = document.getElementById('game-board');
    const resetButton = document.getElementById('reset-button');
    const attemptsDisplay = document.getElementById('attempts');
    const timeDisplay = document.getElementById('time');

    resetButton.addEventListener('click', resetGame);

    function shuffle(array) {
        array.sort(() => Math.random() - 0.5);
    }

    function createBoard() {
        shuffle(cardsArray);
        cardsArray.forEach(card => {
            const cardElement = document.createElement('div');
            cardElement.classList.add('card');
            cardElement.dataset.card = card;
            cardElement.addEventListener('click', flipCard);
            const imgElement = document.createElement('img');
            imgElement.src = `images/${card}.png`;
            cardElement.appendChild(imgElement);
            gameBoard.appendChild(cardElement);
        });
    }

    function startTimer() {
        timer = setInterval(() => {
            seconds++;
            timeDisplay.textContent = seconds;
        }, 1000);
    }

    function stopTimer() {
        clearInterval(timer);
    }

    function resetTimer() {
        stopTimer();
        seconds = 0;
        timeDisplay.textContent = seconds;
    }

    function flipCard() {
        if (lockBoard || this === firstCard) return;

        this.classList.add('flipped');
        
        if (!firstCard) {
            firstCard = this;
            startTimer();
            return;
        }

        secondCard = this;
        attempts++;
        attemptsDisplay.textContent = attempts;
        checkForMatch();
    }

    function checkForMatch() {
        if (firstCard.dataset.card === secondCard.dataset.card) {
            disableCards();
            matches++;
            if (matches === cardsArray.length / 2) {
                setTimeout(() => {
                    alert('Você venceu!');
                    stopTimer();
                }, 500);
            }
        } else {
            unflipCards();
        }
    }

    function disableCards() {
        firstCard.removeEventListener('click', flipCard);
        secondCard.removeEventListener('click', flipCard);
        resetBoard();
    }

    function unflipCards() {
        lockBoard = true;
        setTimeout(() => {
            firstCard.classList.remove('flipped');
            secondCard.classList.remove('flipped');
            resetBoard();
        }, 1000);
    }

    function resetBoard() {
        [firstCard, secondCard, lockBoard] = [null, null, false];
    }

    function resetGame() {
        matches = 0;
        attempts = 0;
        firstCard = null;
        secondCard = null;
        lockBoard = false;
        gameBoard.innerHTML = '';
        attemptsDisplay.textContent = attempts;
        resetTimer();
        createBoard();
    }

    createBoard();
});
